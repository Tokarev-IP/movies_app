package test.app.retrofiteducationfilms

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.MovementMethod
import android.widget.Button
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import test.app.retrofiteducationfilms.fragments.ItemFragment
import test.app.retrofiteducationfilms.fragments.ListFragment

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, ListFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }
}
