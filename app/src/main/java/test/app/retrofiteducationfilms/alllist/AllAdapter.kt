package test.app.retrofiteducationfilms.alllist

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
import test.app.retrofiteducationfilms.api.Movie
import test.app.retrofiteducationfilms.api.MoviesResponse
import test.app.retrofiteducationfilms.db.Movies

class AllAdapter():  PagedListAdapter<Movie , AllAdapter.AllViewHolder>(DIFF_CALLBACK) {

    class AllViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal val movieTitle: TextView = v.findViewById(R.id.allitem_title)
        internal val overview: TextView = v.findViewById(R.id.allitem_overView)
        internal val imageView : ImageView = v.findViewById(R.id.allitem_imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.all_item_list, parent, false)
        return AllViewHolder(view)
    }

    @SuppressLint("ShowToast", "ResourceAsColor")
    override fun onBindViewHolder(holder: AllViewHolder, position: Int) {
        val current: Movie? = getItem(position)

        holder.movieTitle.text = current?.title
        holder.overview.text = current?.overview

        Picasso.get()
            .load(current?.posterPath)
            .placeholder(R.drawable.ic_baseline_image_search_24)
            .error(R.drawable.ic_baseline_image_search_24)
            .resize(400, 680)
            .centerCrop()
            .noFade()
            .into(holder.imageView)

        }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(old: Movie,
                                         new: Movie): Boolean = old.id == new.id

            override fun areContentsTheSame(old: Movie,
                                            new: Movie): Boolean = old == new
        }
    }
}