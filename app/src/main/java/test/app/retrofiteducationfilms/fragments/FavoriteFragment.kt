package test.app.retrofiteducationfilms.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import test.app.retrofiteducationfilms.R
import test.app.retrofiteducationfilms.db.MoviesRoomDatabase
import test.app.retrofiteducationfilms.favlist.FavAdapter
import test.app.retrofiteducationfilms.favlist.FavoriteRepository
import test.app.retrofiteducationfilms.favlist.FavoriteViewModel
import io.reactivex.Observable


class FavoriteFragment : Fragment() {

    companion object {
        fun newInstance(): FavoriteFragment {
            return FavoriteFragment()
        }
    }

    private val favViewModel by lazy { ViewModelProviders.of(this).get(FavoriteViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mInflater = inflater.inflate(R.layout.fragment_favorite, container, false)

        val recyclerView = mInflater.findViewById<RecyclerView>(R.id.favorite_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val favAdapter = FavAdapter()
        recyclerView.adapter = favAdapter

//        val editText: EditText = mInflater.findViewById(R.id.find_edittext)
//
//        editText.addTextChangedListener {
//
//        }


        val db= MoviesRoomDatabase.getDatabase(context as AppCompatActivity)

        val rep = FavoriteRepository(db, favViewModel)
        rep.downloadData()

        favViewModel.getData().observe(this) {
            favAdapter.submitList(it)
        }

        return mInflater
    }


    override fun onStop() {
        super.onStop()
    }
}


