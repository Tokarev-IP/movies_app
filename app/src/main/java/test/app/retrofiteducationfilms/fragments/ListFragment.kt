package test.app.retrofiteducationfilms.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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

//    private val userViewModel by lazy {ViewModelProviders.of(this).get(MoviesViewModel::class.java)}

    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

       // MoviesRepository().downloadTopRatedMovies()

        val mInflater = inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView = mInflater.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

//        val adapter = MoviesAdapter(context as AppCompatActivity)

        //adapter.update(array)

//        val adapter = MoviesAdapter(context as AppCompatActivity)

        val downloadButton: Button = mInflater.findViewById(R.id.api_start)

        downloadButton.setOnClickListener {

            MovieApiClient.apiClient
                    .getTopRatedMovies("cd4ce7cfb36a8621325e99dac72491cb", "en-US")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { it ->
                                recyclerView.adapter = MoviesAdapter(it.results, context as AppCompatActivity)
                            },
                            { error ->
                                Log.e("ERROR", error.toString())
                            }
                    )
        }

//        userViewModel.getMovieList().observe(this, Observer {
//            it?.let {
//                adapter.update(it)
//              //  MoviesAdapter(context as AppCompatActivity).update(it)
//            }
//        })

//        Picasso.get()
//            .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1B2YJCYyRudISmfSWCRfc95gAtq.jpg")
//            .placeholder(R.drawable.ic_baseline_image_search_24)
//            .error(R.drawable.ic_baseline_image_search_24)
//            //.resize(150, 150)
//            //.centerCrop()
//            .noFade()
//            .into(image_View)

        return mInflater
    }

}