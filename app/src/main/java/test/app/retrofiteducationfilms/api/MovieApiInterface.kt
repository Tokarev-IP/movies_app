package test.app.retrofiteducationfilms.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import test.app.retrofiteducationfilms.BuildConfig

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

    @GET("movie/now_playing")
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String ,
        @Query("language") language: String ,
        @Query("page") page: Int
    ): Single<MoviesResponse>

}
