package test.app.retrofiteducationfilms.alllist

import android.annotation.SuppressLint
import android.util.Log
import androidx.paging.PageKeyedDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import test.app.retrofiteducationfilms.api.Movie
import test.app.retrofiteducationfilms.api.MovieApiClient

class PagedDataSource(): PageKeyedDataSource<Int, Movie>() {

    //My themoviedb.org API KEY
    private val API_KEY = "cd4ce7cfb36a8621325e99dac72491cb"
    //"en-US"

    @SuppressLint("CheckResult")
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        val currentPage = 1
        val nextPage = currentPage + 1

        MovieApiClient.apiClient.getNowPlayingMovies(API_KEY, "en-US", currentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { it ->
                            callback.onResult(it.results, null, nextPage)
                        },
                        { error ->
                            Log.e("ERROR", error.toString())
                        }
                )
    }


    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val crntPage = params.key
        val nxtPage = crntPage + 1

        MovieApiClient.apiClient.getNowPlayingMovies(API_KEY, "en-US", crntPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { it ->
                            callback.onResult(it.results, nxtPage)
                        },
                        { error ->
                            Log.e("ERROR", error.toString())
                        }
                )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        TODO("Not yet implemented")
    }
}