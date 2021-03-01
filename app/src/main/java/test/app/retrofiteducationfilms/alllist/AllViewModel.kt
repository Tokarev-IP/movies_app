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

    private val pagedDataSource = PagedDataSourceFactory()

    private val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(30)
            .setPrefetchDistance(10)
            .setEnablePlaceholders(false)
            .build()

    @JvmName("getData1")
    fun getMovies(): LiveData<PagedList<Movie>> {
        return LivePagedListBuilder(pagedDataSource, config)
                .build()
    }
}