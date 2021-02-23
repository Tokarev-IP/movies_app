package test.app.retrofiteducationfilms

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import test.app.retrofiteducationfilms.fragments.AllFragment
import test.app.retrofiteducationfilms.fragments.FavoriteFragment
import test.app.retrofiteducationfilms.fragments.ListFragment

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {

                R.id.action_one -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, ListFragment.newInstance())
                    .addToBackStack(null)
                    .commit()

                R.id.action_two -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, FavoriteFragment.newInstance())
                    .addToBackStack(null)
                    .commit()

                R.id.action_three -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, AllFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, ListFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }
}
