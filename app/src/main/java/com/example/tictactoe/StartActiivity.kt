package com.example.tictactoe

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.LAN.ClientActivity
import com.example.tictactoe.LAN.HostActivity
import com.example.tictactoe.databinding.ActivityStartActiivityBinding

class StartActiivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartActiivityBinding
    private lateinit var letplay: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        letplay = MediaPlayer.create(this,R.raw.play)


        binding = ActivityStartActiivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener{
            startActivity((Intent(this@StartActiivity,MainActivity::class.java)))
            letplay.start()
            finish()
        }
        binding.btnmoveHOST.setOnClickListener{
            startActivity((Intent(this@StartActiivity,HostActivity::class.java)))
            finish()
        }
        binding.btnmoveJOIN.setOnClickListener{
            startActivity((Intent(this@StartActiivity,ClientActivity::class.java)))
            finish()
        }


    }
}