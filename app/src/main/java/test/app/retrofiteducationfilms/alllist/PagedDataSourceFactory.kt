package test.app.retrofiteducationfilms.alllist

import androidx.paging.DataSource
import test.app.retrofiteducationfilms.api.Movie

class PagedDataSourceFactory: DataSource.Factory<Int, Movie>() {

    val latestSource = PagedDataSource()

    override fun create(): DataSource<Int, Movie> {
        return latestSource
    }
}