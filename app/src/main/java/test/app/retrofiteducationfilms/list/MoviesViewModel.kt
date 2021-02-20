package test.app.retrofiteducationfilms.list

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.app.retrofiteducationfilms.api.Movie

@SuppressLint("CheckResult")
class MoviesViewModel : ViewModel() {

    var moviesData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun setData(mData: List<Movie>){
        moviesData.value = mData
    }

    fun getMovieList() = moviesData

}