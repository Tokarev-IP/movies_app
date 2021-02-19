package test.app.retrofiteducationfilms

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import test.app.retrofiteducationfilms.db.MovieDao
import test.app.retrofiteducationfilms.db.Movies
import test.app.retrofiteducationfilms.fragments.ItemFragment
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class MoviesAdapter(private val mContext: AppCompatActivity, private val wordDao: MovieDao)
    : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private var listMovies: List<Movie> = emptyList()
    lateinit var mIFragment: Fragment

    class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal val movieTitle: TextView = v.findViewById(R.id.title_view)
        internal val data: TextView = v.findViewById(R.id.data_view)
        internal val rating: TextView = v.findViewById(R.id.rating)
        internal val adultView: TextView = v.findViewById(R.id.adult_view)
        internal val mItemView : View = v.findViewById(R.id.movie_fragment)
        internal val mImageView : ImageView = v.findViewById(R.id.image_view)
        internal val mFavView : ImageView = v.findViewById(R.id.favorite_image)
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
        holder.data.text = current.releaseDate.substring(0,4)
        holder.rating.text = current.voteAverage.toString()
        if (current.isAdult) holder.adultView.text = "18+"
        holder.rating.text = current.voteAverage.toString()

        Picasso.get()
                .load(current.posterPath)
                .placeholder(R.drawable.ic_baseline_image_search_24)
                .error(R.drawable.ic_baseline_image_search_24)
                .resize(400, 680)
                .centerCrop()
                .noFade()
                .into(holder.mImageView)

        holder.mFavView.setOnClickListener {
            wordDao.insert(Movies(current.id, current.isAdult, current.overview, current.releaseDate,
                    current.title, current.originalLanguage, current.voteAverage,
            current.posterPath, current.backdropPath))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            {
                            Toast.makeText(mContext, "Complete", Toast.LENGTH_LONG)
                            },
                            { error ->
                        Log.e("ERROR", error.toString())
                    }
                    )

        }

        holder.mItemView.setOnClickListener {
            mIFragment = ItemFragment(current)
            mContext.supportFragmentManager
                    .beginTransaction()
                    .replace( R.id.fragment_container, mIFragment)
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

