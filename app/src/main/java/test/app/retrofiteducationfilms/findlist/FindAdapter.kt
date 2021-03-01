package test.app.retrofiteducationfilms.findlist

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


class FindAdapter() : RecyclerView.Adapter<FindAdapter.FindViewHolder>() {

    private var listMovies: List<Movies> = emptyList()

    class FindViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal val movieTitle: TextView = v.findViewById(R.id.find_title_textView)
        internal val mFavView : ImageView = v.findViewById(R.id.find_imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FindViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.find_item, parent, false)
        return FindViewHolder(view)
    }

    @SuppressLint("ShowToast", "ResourceAsColor")
    override fun onBindViewHolder(holder: FindViewHolder, position: Int) {
        val current = listMovies[position]

        holder.movieTitle.text = current.title

        Picasso.get()
                .load(current.posterPath)
                .placeholder(R.drawable.ic_baseline_image_search_24)
                .error(R.drawable.ic_baseline_image_search_24)
                .resize(400, 680)
                .centerCrop()
                .noFade()
                .into(holder.mFavView)

    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setData(movies: List<Movies>){
        listMovies = movies
        notifyDataSetChanged()
    }
}