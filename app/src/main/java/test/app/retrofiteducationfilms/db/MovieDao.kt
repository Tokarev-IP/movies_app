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

    @Query("SELECT * FROM favorite_movies WHERE title LIKE ''||:title||'%'")
    fun getByTitle(title: String): Maybe<List<Movies>>

    @Query("SELECT * FROM favorite_movies WHERE id = :id")
    fun getById(id: Int): Maybe<List<Movies>>

    @Insert
    fun insert(movie: Movies): Completable

    @Delete
    fun delete(movie: Movies): Completable

}