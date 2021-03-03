package test.app.retrofiteducationfilms.findlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import test.app.retrofiteducationfilms.R
import test.app.retrofiteducationfilms.db.MoviesRoomDatabase
import java.util.concurrent.TimeUnit
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.*
import io.reactivex.Observable

class FindFragment : Fragment() {

    companion object {
        fun newInstance(): FindFragment {
            return FindFragment()
        }
    }

    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val mInflater = inflater.inflate(R.layout.fragment_find, container, false)

        val mEditText: EditText = mInflater.findViewById(R.id.find_edit_text)

        val recyclerView = mInflater.findViewById<RecyclerView>(R.id.find_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val findAdapter = FindAdapter()
        recyclerView.adapter = findAdapter

        val db= MoviesRoomDatabase.getDatabase(context as AppCompatActivity)

        mEditText.addTextChangedListener {
                if (it.toString() != "") {
                    Log.d("FIND", "Searching")
                    db.movieDao().getByTitle(it.toString())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    {
                                        it?.let {
                                            findAdapter.setData(it)
                                        } },
                                    { error ->
                                        Log.e("ERROR", error.toString())
                                    })
                }
            }

        return mInflater
    }
}