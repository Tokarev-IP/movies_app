package test.app.retrofiteducationfilms.favlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.app.retrofiteducationfilms.db.Movies

class FavoriteViewModel: ViewModel() {

    var favMoviesData: MutableLiveData<List<Movies>> = MutableLiveData()

    fun setData(mData: List<Movies>){
        favMoviesData.value = mData
    }

    fun getMovieList() = favMoviesData
}