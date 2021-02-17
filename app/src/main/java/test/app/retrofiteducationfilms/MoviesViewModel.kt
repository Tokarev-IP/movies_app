package test.app.retrofiteducationfilms

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class MoviesViewModel : ViewModel() {

    var moviesData: MutableLiveData<List<Movie>> = MutableLiveData()

    init {
       // moviesData =
    }

    fun setData(mData: List<Movie>){
        moviesData.value = mData
    }

    fun getMovieList() = moviesData

}