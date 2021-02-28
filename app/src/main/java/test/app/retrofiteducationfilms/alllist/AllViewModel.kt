package test.app.retrofiteducationfilms.alllist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import test.app.retrofiteducationfilms.api.Movie
import test.app.retrofiteducationfilms.api.MoviesResponse

class AllViewModel: ViewModel() {

    val pagedDataSource = PagedDataSourceFactory()

    private val config = PagedList.Config.Builder()
            .setPageSize(5)
            .setInitialLoadSizeHint(20)
            .setPrefetchDistance(5)
            .setEnablePlaceholders(false)
            .build()

    lateinit var allMoviesFactory: DataSource.Factory<Int, Movie>

    fun setData(mData: DataSource.Factory<Int, Movie>){
        allMoviesFactory = mData
    }

    @JvmName("getData1")
    fun getMovies(): LiveData<PagedList<Movie>> {
        return LivePagedListBuilder(pagedDataSource, config)
                .build()
    }
}