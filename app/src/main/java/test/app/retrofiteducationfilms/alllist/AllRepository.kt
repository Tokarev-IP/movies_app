package test.app.retrofiteducationfilms.alllist

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import test.app.retrofiteducationfilms.api.MovieApiClient

class AllRepository(private val mViewModel: AllViewModel) {

    //My themoviedb.org API KEY
    private val API_KEY = "cd4ce7cfb36a8621325e99dac72491cb"

    @SuppressLint("CheckResult")
    fun getNowPlayingMovies() {
        MovieApiClient.apiClient.getNowPlayingMovies(API_KEY, "en-US", 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { it ->
                    mViewModel.setData(it.results)
                },
                { error ->
                    Log.e("ERROR", error.toString())
                }
            )
        return
    }
}