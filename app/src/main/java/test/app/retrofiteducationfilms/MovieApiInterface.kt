package test.app.retrofiteducationfilms

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiInterface {

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Single<MoviesResponse>

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
    ): Single<MoviesResponse>

}
