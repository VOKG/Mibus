package com.example.mibus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mibus.databinding.ActivityMainBinding
import timber.log.Timber

const val KEY_REVENUE = "key_revenue"

class MainActivity : AppCompatActivity() {
    private var revenue = 0


    private val binding: ActivityMainBinding by lazy(LazyThreadSafetyMode.NONE){
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        Timber.i("onStart")
       // supportActionBar?.setDisplayHomeAsUpEnabled(true)
       // supportActionBar?.title = "MIBUS"


        // setSupportActionBar(binding.toolbar)

        //  val button = findViewById<Button>(R.id.button)
     ///   button.setOnClickListener(this)
        if (savedInstanceState != null){
          revenue =  savedInstanceState.getInt(KEY_REVENUE)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_REVENUE,revenue)
        Timber.i("onSaveInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart")
    }
    override fun onResume() {
        super.onResume()
        Timber.i("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause")
    }
    override fun onStop() {
        super.onStop()
        Timber.i("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy")
    }


    /*  override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return super.onSupportNavigateUp()
    }*/


}