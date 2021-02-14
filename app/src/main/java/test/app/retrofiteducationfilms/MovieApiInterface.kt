package test.app.retrofiteducationfilms

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiInterface {

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Single<MoviesResponse>

    @GET("/tv/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Single<MoviesResponse>

    @GET("movie/{movie_id}/images")
    fun getImagesMovies(
            @Path("movie_id") productId: Int,
            @Query("api_key") apiKey: String
    ): Single<MoviesResponse>

}
