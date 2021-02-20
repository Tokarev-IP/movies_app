package test.app.retrofiteducationfilms.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single
import io.reactivex.Completable

@Dao
interface MovieDao {

    @Query("SELECT * FROM favorite_movies")
    fun getAll(): Single<List<Movies>>

    @Insert
    fun insert(movie: Movies): Completable

    @Delete
    fun delete(movie: Movies): Completable
}