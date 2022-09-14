package com.example.mibus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mibus.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setContentView(binding.root)

       // supportActionBar?.setDisplayHomeAsUpEnabled(true)
       // supportActionBar?.title = "MIBUS"


       // setSupportActionBar(binding.toolbar)

     //  val button = findViewById<Button>(R.id.button)
     ///   button.setOnClickListener(this)

    }








}