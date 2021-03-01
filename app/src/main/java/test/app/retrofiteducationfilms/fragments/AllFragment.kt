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
import test.app.retrofiteducationfilms.alllist.AllAdapter
import test.app.retrofiteducationfilms.alllist.AllRepository
import test.app.retrofiteducationfilms.alllist.AllViewModel
import test.app.retrofiteducationfilms.alllist.PagedDataSource


class AllFragment : Fragment() {

    companion object {
        fun newInstance(): AllFragment {
            return AllFragment()
        }
    }

    private val allViewModel by lazy {ViewModelProviders.of(this).get(AllViewModel::class.java)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val minflater = inflater.inflate(R.layout.fragment_all, container, false)

        val recyclerView = minflater.findViewById<RecyclerView>(R.id.all_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val allAdapter = AllAdapter()
        recyclerView.adapter = allAdapter

        allViewModel.getMovies().observe(this, {
            allAdapter.submitList(it)
        })

        return minflater
    }

}