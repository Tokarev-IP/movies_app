package test.app.retrofiteducationfilms.favlist

import androidx.lifecycle.*
import androidx.paging.*
import test.app.retrofiteducationfilms.db.Movies


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