package test.app.retrofiteducationfilms.alllist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.app.retrofiteducationfilms.api.Movie

class AllViewModel: ViewModel() {

    var allMoviesData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun setData(mData: List<Movie>){
        allMoviesData.value = mData
    }

    fun getMovieList() = allMoviesData
}