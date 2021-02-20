package test.app.retrofiteducationfilms.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import test.app.retrofiteducationfilms.R
import test.app.retrofiteducationfilms.db.MoviesRoomDatabase
import test.app.retrofiteducationfilms.favlist.FavAdapter
import test.app.retrofiteducationfilms.favlist.FavoriteRepository
import test.app.retrofiteducationfilms.favlist.FavoriteViewModel

class FavoriteFragment : Fragment() {

    companion object {
        fun newInstance(): FavoriteFragment {
            return FavoriteFragment()
        }
    }

    private val userViewModel by lazy { ViewModelProviders.of(this).get(FavoriteViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val mInflater = inflater.inflate(R.layout.fragment_favorite, container, false)

        val db = MoviesRoomDatabase.getDatabase(context as AppCompatActivity)

        val favRepository = FavoriteRepository(db, userViewModel)

        val recyclerView = mInflater.findViewById<RecyclerView>(R.id.favorite_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val favAdapter = FavAdapter()
        recyclerView.adapter = favAdapter

        favRepository.getFavData()

        userViewModel.getMovieList().observe(this, Observer {
            it?.let {
                favAdapter.setData(it)
            }
        })

        return mInflater
    }

}