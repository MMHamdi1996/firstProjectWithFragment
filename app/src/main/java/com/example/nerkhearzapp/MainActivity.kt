package com.example.nerkhearzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nerkhearzapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goldButton.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.fragmentContainerView.id, GoldFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.dollarButton.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.fragmentContainerView.id, DollarFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}