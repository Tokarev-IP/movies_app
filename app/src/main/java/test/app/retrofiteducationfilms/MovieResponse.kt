package test.app.retrofiteducationfilms


import android.annotation.SuppressLint
import android.util.Log
import com.google.gson.annotations.SerializedName
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

data class MoviesResponse (
    var page: Int,
    var results: List<Movie>,
    @SerializedName("total_results")
    var totalResults: Int,
    @SerializedName("total_pages")
    var totalPages: Int
    )

data class Movie(
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("adult")
    var isAdult: Boolean,
    @SerializedName("overview")
    var overview: String?,
    @SerializedName("release_date")
    var releaseDate: String?,
    var genreIds: List<Int>,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("original_title")
    var originalTitle: String?,
    @SerializedName("original_language")
    var originalLanguage: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("popularity")
    var popularity: Double?,
    @SerializedName("vote_count")
    var voteCount: Int?,
    @SerializedName("video")
    var video: Boolean?,
    @SerializedName("vote_average")
    var voteAverage: Double?
) {}


