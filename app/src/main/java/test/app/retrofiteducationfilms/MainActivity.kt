package test.app.retrofiteducationfilms

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.MovementMethod
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import test.app.retrofiteducationfilms.fragments.ItemFragment
import test.app.retrofiteducationfilms.fragments.ListFragment

class MainActivity : AppCompatActivity() {

//    private val userViewModel by lazy { ViewModelProviders.of(this).get(MoviesViewModel::class.java)}

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val repository = MoviesRepository(userViewModel)

        val startButton: Button = findViewById(R.id.start_button)
        startButton.setOnClickListener {
//            userViewModel.downloadTopRatedMovies()
//            repository.downloadTopRatedMovies()
        }

//        MoviesRepository().downloadTopRatedMovies()


            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, ListFragment.newInstance())
                .addToBackStack(null)
                .commit()


//        // My themoviedb.org API KEY
//        private val API_KEY = "cd4ce7cfb36a8621325e99dac72491cb"
    }
}
