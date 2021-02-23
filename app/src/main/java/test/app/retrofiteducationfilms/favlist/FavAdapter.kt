package test.app.retrofiteducationfilms.favlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import test.app.retrofiteducationfilms.R
import test.app.retrofiteducationfilms.db.Movies

class FavAdapter() : RecyclerView.Adapter<FavAdapter.FavMovieViewHolder>() {

    private var listMovies: List<Movies> = emptyList()

    class FavMovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal val movieTitleFav: TextView = v.findViewById(R.id.title_fav)
        internal val dataFav: TextView = v.findViewById(R.id.datareleas_fav)
        internal val ratingFav: TextView = v.findViewById(R.id.average_fav)
        internal val origLanguageFav: TextView = v.findViewById(R.id.original_language_fav)
        internal val overviewFav: TextView = v.findViewById(R.id.overview_fav)
        internal val mImageViewFav : ImageView = v.findViewById(R.id.fav_image_left)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.favorite_item, parent, false)
        return FavMovieViewHolder(view)
    }

    @SuppressLint("ShowToast", "SetTextI18n")
    override fun onBindViewHolder(holder: FavMovieViewHolder, position: Int) {
        val current = listMovies[position]
        holder.movieTitleFav.text = current.title
        holder.dataFav.text = current.releaseDate
        holder.ratingFav.text = current.voteAverage.toString()+"/10"
        holder.origLanguageFav.text = "Original language: "+ current.originalLanguage
        holder.overviewFav.text = current.overview

        Picasso.get()
            .load(current.posterPath)
            .placeholder(R.drawable.ic_baseline_image_search_24)
            .error(R.drawable.ic_baseline_image_search_24)
            .into(holder.mImageViewFav)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setData(movies: List<Movies>){
        listMovies = movies
        notifyDataSetChanged()
    }

}