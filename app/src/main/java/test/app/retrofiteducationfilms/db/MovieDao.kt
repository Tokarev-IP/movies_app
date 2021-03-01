package test.app.retrofiteducationfilms.db


import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single
import io.reactivex.Maybe
import io.reactivex.Completable

@Dao
interface MovieDao {

    @Query("SELECT * FROM favorite_movies")
    fun getAll(): DataSource.Factory<Int, Movies>
//''||:mTitle||'%'
    @Query("SELECT * FROM favorite_movies WHERE title = :mTitle")
    fun getByTitle(mTitle: String): Maybe<List<Movies>>

    @Insert
    fun insert(movie: Movies): Completable

    @Delete
    fun delete(movie: Movies): Completable

}