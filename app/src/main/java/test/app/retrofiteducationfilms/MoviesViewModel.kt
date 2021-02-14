package test.app.retrofiteducationfilms

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class MoviesViewModel : ViewModel() {

    var moviesData: MutableLiveData<List<Movie>> = MutableLiveData()

    // My themoviedb.org API KEY
   // val API_KEY = "cd4ce7cfb36a8621325e99dac72491cb"

    init {
        if (MoviesRepository().moviesData!=null) moviesData.value = MoviesRepository().moviesData
    }

    fun getMovieList() = moviesData
}