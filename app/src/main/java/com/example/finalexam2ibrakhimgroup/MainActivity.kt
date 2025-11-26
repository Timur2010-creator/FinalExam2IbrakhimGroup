package com.example.finalexam2ibrakhimgroup

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var counter = 0
    private lateinit var pref: PrefManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        pref= PrefManager(this)

        val counterText = findViewById<TextView>(R.id.tv_Text)
        val incrementButton = findViewById<Button>(R.id.Button)
        counter = pref.getCount()
        counterText.text = counter.toString()


        incrementButton.setOnClickListener {
            counter++
            counterText.text = counter.toString()
            pref.saveCount(counter)
        }
    }
}