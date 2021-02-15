package test.app.retrofiteducationfilms

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviesRepository(private val mviewModel : MoviesViewModel) {

    lateinit var moviesData: List<Movie>
//    lateinit var mViewModel: MoviesViewModel

        @SuppressLint("CheckResult")
        fun downloadTopRatedMovies() {

            MovieApiClient.apiClient.getTopRatedMovies("cd4ce7cfb36a8621325e99dac72491cb", "en-US")
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribe(
                            { it ->
                                //moviesData = it.results
                                mviewModel.setData(it.results)
                            },
                            { error ->
                                Log.e("ERROR", error.toString())
                            }
                    )

        }
}