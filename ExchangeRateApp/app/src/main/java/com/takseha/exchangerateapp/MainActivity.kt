package com.takseha.exchangerateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getRatesData()

        val area1 = findViewById<TextView>(R.id.baseCodeBodyArea)
        val area2 = findViewById<TextView>(R.id.dateBodyArea)
        val area3 = findViewById<TextView>(R.id.KRWBodyArea)
        val area4 = findViewById<TextView>(R.id.searchBodyArea)

        val area5 = findViewById<EditText>(R.id.searchTitleArea)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            viewModel.getCountryRate(area5.text.toString())
        }

        viewModel.liveWord1.observe(this, Observer {
            area1.text = it.toString()
        })
        viewModel.liveWord2.observe(this, Observer {
            area2.text = it.toString()
        })
        viewModel.liveWord3.observe(this, Observer {
            area3.text = it.toString()
        })
        viewModel.liveWord4.observe(this, Observer {
            area4.text = it.toString()
        })
    }
}