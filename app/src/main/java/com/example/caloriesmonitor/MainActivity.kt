package com.example.caloriesmonitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caloriesmonitor.databinding.ActivityMainBinding
import com.example.caloriesmonitor.screens.home.presentation.HomeFragment

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_fragment_container,HomeFragment())
            .commit()


    }
}