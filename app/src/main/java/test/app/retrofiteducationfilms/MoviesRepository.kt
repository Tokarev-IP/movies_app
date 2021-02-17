package test.app.retrofiteducationfilms

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class MoviesRepository(private val mviewModel : MoviesViewModel) {

    //My themoviedb.org API KEY
    private val API_KEY = "cd4ce7cfb36a8621325e99dac72491cb"

    @SuppressLint("CheckResult")
    fun downloadTopRatedMovies() {
        MovieApiClient.apiClient.getTopRatedMovies(API_KEY, "en-US")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { it ->
                            mviewModel.setData(it.results)
                        },
                        { error ->
                            Log.e("ERROR", error.toString())
                        }
                )
    }

    @SuppressLint("CheckResult")
    fun downloadPopularMovies() {
        MovieApiClient.apiClient.getPopularMovies(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { it ->
                            mviewModel.setData(it.results)
                        },
                        { error ->
                            Log.e("ERROR", error.toString())
                        }
                )
    }

}