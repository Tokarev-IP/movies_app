package test.app.retrofiteducationfilms.favlist

import androidx.lifecycle.ViewModel
import androidx.paging.*
import test.app.retrofiteducationfilms.db.MoviesRoomDatabase
import test.app.retrofiteducationfilms.db.Movies

class FavoriteRepository(private val db: MoviesRoomDatabase, private val favViewModel: FavoriteViewModel): ViewModel() {

    fun downloadData() {
        val data: DataSource.Factory<Int, Movies> = db.movieDao().getAll()
        favViewModel.setData(data)
    }
}