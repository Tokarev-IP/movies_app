package test.app.retrofiteducationfilms.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import test.app.retrofiteducationfilms.*

class ListFragment() : Fragment() {

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }

    private val userViewModel by lazy { ViewModelProviders.of(this).get(MoviesViewModel::class.java) }

    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val mInflater = inflater.inflate(R.layout.fragment_list, container, false)

       val repository = MoviesRepository(userViewModel)

        val recyclerView = mInflater.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = MoviesAdapter(context as AppCompatActivity)
        recyclerView.adapter = adapter

        val downloadPopular: Button = mInflater.findViewById(R.id.api_popular)
        val downloadTop: Button = mInflater.findViewById(R.id.api_top)

        downloadPopular.setOnClickListener {
            repository.downloadPopularMovies()
        }

        downloadTop.setOnClickListener {
            repository.downloadTopRatedMovies()
        }

        userViewModel.getMovieList().observe(this, Observer {
            it?.let {
                adapter.setData(it)
            }
        })

        return mInflater
    }

}