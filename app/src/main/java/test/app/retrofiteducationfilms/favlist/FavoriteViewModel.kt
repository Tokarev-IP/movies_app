package test.app.retrofiteducationfilms.favlist

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.paging.*
import test.app.retrofiteducationfilms.db.MovieDao
import test.app.retrofiteducationfilms.db.Movies
import test.app.retrofiteducationfilms.db.MoviesRoomDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

class FavoriteViewModel(): ViewModel() {

    lateinit var dataFactory: DataSource.Factory<Int, Movies>

    private val config = PagedList.Config.Builder()
            .setPageSize(5)
            .setInitialLoadSizeHint(20)
            .setPrefetchDistance(5)
            .setEnablePlaceholders(false)
            .build()

    @JvmName("getData1")
    fun getData(): LiveData<PagedList<Movies>>{
        return LivePagedListBuilder(dataFactory, config)
                .build()
    }

    fun setData(data: DataSource.Factory<Int, Movies>){
        dataFactory = data
    }
}

//    var favMoviesData: MutableLiveData<List<Movies>> = MutableLiveData()


//    val items: Flow<PagingData<Movies>> = Pager(
//        PagingConfig(
//            pageSize = 5,
//        )
//    ){
//        db.movieDao().getAll()
//    }.flow


//    fun setData(mData: List<Movies>){
//        favMoviesData.value = mData
//    }
//
//    fun getMovieList() = favMoviesData
//}