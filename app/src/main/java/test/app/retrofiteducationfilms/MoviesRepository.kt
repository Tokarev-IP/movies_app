package test.app.retrofiteducationfilms

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviesRepository {

    lateinit var moviesData: List<Movie>

        @SuppressLint("CheckResult")
        fun downloadTopRatedMovies() {

            MovieApiClient.apiClient.getTopRatedMovies("cd4ce7cfb36a8621325e99dac72491cb", "en-US")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { it ->
                                moviesData = it.results
                            },
                            { error ->
                                Log.e("ERROR", error.toString())
                            }
                    )

        }
}