package test.app.retrofiteducationfilms.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface MovieDao {

    @Query ("SELECT * FROM favorite_movies")
    fun getAll(): Single<Movies>

    @Insert
    fun insert(movie: Movies)

    @Delete
    fun delete(movie: Movies)
}