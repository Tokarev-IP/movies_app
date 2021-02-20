package test.app.retrofiteducationfilms.favlist

import android.annotation.SuppressLint
import android.util.Log
import test.app.retrofiteducationfilms.db.MoviesRoomDatabase
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class FavoriteRepository(private val db: MoviesRoomDatabase, private val favViewModel: FavoriteViewModel) {

    @SuppressLint("CheckResult")
    fun getFavData() {
        db.movieDao().getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       favViewModel.setData(it)
            },
                {
                    Log.e("ERROR", it.toString())
                })
    }
}