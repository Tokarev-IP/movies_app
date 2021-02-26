package test.app.retrofiteducationfilms.favlist

import android.annotation.SuppressLint
import android.util.Log
import androidx.arch.core.executor.ArchTaskExecutor
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import test.app.retrofiteducationfilms.db.MoviesRoomDatabase
import test.app.retrofiteducationfilms.db.Movies
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.asCoroutineDispatcher

class FavoriteRepository(private val db: MoviesRoomDatabase, private val favViewModel: FavoriteViewModel): ViewModel() {

    fun downloadData() {
        val data: DataSource.Factory<Int, Movies> = db.movieDao().getAll()
        favViewModel.setData(data)
    }



//        @SuppressLint("RestrictedApi")
//        val moviesList: LiveData<PagingData<Movies>> =
//            Pager(
//                PagingConfig(pageSize = 3),
//                null,
//                db.movieDao().getAll().asPagingSourceFactory(
//                    ArchTaskExecutor.getIOThreadExecutor().asCoroutineDispatcher()
//                )
//            ).liveData


//    @SuppressLint("CheckResult")
//    fun getFavData() {
//        db.movieDao().getAll()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                       favViewModel.setData(it)
//            },
//                {
//                    Log.e("ERROR", it.toString())
//                })
//    }
}