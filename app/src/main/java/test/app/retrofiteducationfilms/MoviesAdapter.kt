package test.app.retrofiteducationfilms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import test.app.retrofiteducationfilms.fragments.ItemFragment

class MoviesAdapter(private val mContext: AppCompatActivity)
    : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private var listMovies: List<Movie> = emptyList<Movie>()

    class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal val movieTitle: TextView = v.findViewById(R.id.title)
        internal val data: TextView = v.findViewById(R.id.subtitle)
        internal val movieDescription: TextView = v.findViewById(R.id.description)
        internal val rating: TextView = v.findViewById(R.id.rating)
        internal val mItemView : View = v.findViewById(R.id.movies_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val current = listMovies[position]

        holder.movieTitle.text = current.title
        holder.data.text = current.releaseDate
        holder.movieDescription.text = current.overview
        holder.rating.text = current.voteAverage.toString()

        holder.mItemView.setOnClickListener {
            mContext.supportFragmentManager
                    .beginTransaction()
                    .replace( R.id.fragment_container, ItemFragment.newInstance())
                    .addToBackStack(null)
                    .commit()

        }

    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setData(movies: List<Movie>){
        listMovies = movies
        notifyDataSetChanged()
    }
}

