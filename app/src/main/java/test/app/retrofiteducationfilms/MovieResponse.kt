package test.app.retrofiteducationfilms

import com.google.gson.annotations.SerializedName

data class MoviesResponse (
    var page: Int?,
    var results: List<Movie>,
    @SerializedName("total_results")
    var totalResults: Int?,
    @SerializedName("total_pages")
    var totalPages: Int?
    )

data class Movie(

        @SerializedName("adult")
    var isAdult: Boolean,
        @SerializedName("overview")
    var overview: String,
        @SerializedName("release_date")
    var releaseDate: String,
        var genreIds: List<Int>,
        @SerializedName("id")
    var id: Int,
        @SerializedName("original_title")
    var originalTitle: String,
        @SerializedName("original_language")
    var originalLanguage: String,
        @SerializedName("title")
    var title: String,
        @SerializedName("popularity")
    var popularity: Double,
        @SerializedName("vote_count")
    var voteCount: Int,
        @SerializedName("video")
    var video: Boolean,
        @SerializedName("vote_average")
    var voteAverage: Double
) {
    @SerializedName("poster_path")
    var posterPath: String? = null
        get() = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2$field"

    @SerializedName("backdrop_path")
    var backdropPath: String?= null
        get() = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2$field"
}


