package test.app.retrofiteducationfilms.favlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import test.app.retrofiteducationfilms.R
import test.app.retrofiteducationfilms.db.Movies

class FavAdapter() : PagedListAdapter<Movies, FavAdapter.FavMovieViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.favorite_item, parent, false)
        return FavMovieViewHolder(view)
    }

    @SuppressLint("ShowToast", "SetTextI18n")
    override fun onBindViewHolder(holder: FavMovieViewHolder, position: Int) {
        val moviesObject: Movies? = getItem(position)
        holder.movieTitleFav.text = moviesObject?.title
        holder.dataFav.text = moviesObject?.releaseDate
        holder.ratingFav.text = moviesObject?.voteAverage.toString()+"/10"
        holder.origLanguageFav.text = "Original language: "+ moviesObject?.originalLanguage
        holder.overviewFav.text = moviesObject?.overview

        Picasso.get()
            .load(moviesObject?.posterPath)
            .placeholder(R.drawable.ic_baseline_image_search_24)
            .error(R.drawable.ic_baseline_image_search_24)
            .into(holder.mImageViewFav)
    }

    class FavMovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal val movieTitleFav: TextView = v.findViewById(R.id.title_fav)
        internal val dataFav: TextView = v.findViewById(R.id.datareleas_fav)
        internal val ratingFav: TextView = v.findViewById(R.id.average_fav)
        internal val origLanguageFav: TextView = v.findViewById(R.id.original_language_fav)
        internal val overviewFav: TextView = v.findViewById(R.id.overview_fav)
        internal val mImageViewFav : ImageView = v.findViewById(R.id.fav_image_left)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movies>() {
            override fun areItemsTheSame(old: Movies,
                                         new: Movies): Boolean = old.id == new.id

            override fun areContentsTheSame(old: Movies,
                                            new: Movies): Boolean = old == new
        }
    }

}