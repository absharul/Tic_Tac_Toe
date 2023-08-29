package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityStartActiivityBinding

class StartActiivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartActiivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartActiivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener{
            startActivity((Intent(this@StartActiivity,MainActivity::class.java)))
            finish()
        }

    }
}