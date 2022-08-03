package com.example.mibus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import com.example.mibus.databinding.ActivityMapsBinding


class MainActivity : AppCompatActivity(),View.OnClickListener {

 private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(this)



    }


    override fun onClick(v: View?) {
        intent = Intent(this,MapsActivity::class.java)
        startActivity(intent)
    }

}