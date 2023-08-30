package com.example.tictactoe

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityStartActiivityBinding

class StartActiivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartActiivityBinding
    private lateinit var playsound: MediaPlayer
    private lateinit var letplay: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        letplay = MediaPlayer.create(this,R.raw.play)
        playsound = MediaPlayer.create(this,R.raw.playsound)
        playsound.start()

        binding = ActivityStartActiivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener{
            startActivity((Intent(this@StartActiivity,MainActivity::class.java)))
            letplay.start()
            finish()
        }

    }
}