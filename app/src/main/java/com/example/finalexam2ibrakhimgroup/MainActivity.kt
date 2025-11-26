package com.example.finalexam2ibrakhimgroup

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.finalexam2ibrakhimgroup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: PrefManager
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Инициализация ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = PrefManager(this)

        counter = pref.getCount()
        binding.tvText.text = counter.toString()

        updateButtonText(counter)

        binding.Button.setOnClickListener {
            if (binding.Button.text == "+") {
                if (counter < 10) {
                    counter++
                }
            } else {  "-"
                if (counter > 0) {
                    counter--
                }
            }

            binding.tvText.text = counter.toString()
            updateButtonText(counter)

            // Сохраняем значение
            pref.saveCount(counter)
        }
    }

    private fun updateButtonText(counter: Int) {
        if (counter == 10) {
            binding.Button.text = "-"
        } else if (counter == 0) {
            binding.Button.text = "+"
        }
    }
}
