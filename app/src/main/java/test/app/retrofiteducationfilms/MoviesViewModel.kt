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
        val initialData = Movie("",true, "", null,
                null, null, "","", "", "",
                null, null, null, null)

        val array: ArrayList<Movie> = ArrayList()
        array.add(initialData)
        moviesData.value = array
    }

    fun setData(mData: List<Movie>){
        moviesData.value = mData
    }

    // My themoviedb.org API KEY
    // val API_KEY = "cd4ce7cfb36a8621325e99dac72491cb"

    fun getMovieList() = moviesData

    fun downloadTopRatedMovies() {

        MovieApiClient.apiClient.getTopRatedMovies("cd4ce7cfb36a8621325e99dac72491cb", "en-US")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { it ->
                            //moviesData = it.results
                            setData(it.results)
                        },
                        { error ->
                            Log.e("ERROR", error.toString())
                        }
                )

    }
}