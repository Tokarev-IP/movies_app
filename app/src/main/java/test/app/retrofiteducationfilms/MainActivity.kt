package test.app.retrofiteducationfilms

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.movies_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Получаем Single
       MovieApiClient.apiClient.getPopularMovies(API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { it ->
                    val movies = it.results
                    // Передаем результат в adapter и отображаем элементы
                    recyclerView.adapter = MoviesAdapter(movies, R.layout.list_item_movie)
                },
                { error ->
                    // Логируем ошибку
                    Log.e(TAG, error.toString())
                }
            )
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName

        // TODO - insert your themoviedb.org API KEY here
        private val API_KEY = "cd4ce7cfb36a8621325e99dac72491cb"
    }
}
