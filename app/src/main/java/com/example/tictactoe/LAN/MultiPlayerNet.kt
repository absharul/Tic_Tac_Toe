package com.example.tictactoe.LAN

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.R
import com.example.tictactoe.StartActiivity
import com.example.tictactoe.databinding.ActivityMultiPlayerNetBinding

class MultiPlayerNet : AppCompatActivity() {

    private lateinit var binding: ActivityMultiPlayerNetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMultiPlayerNetBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnHost.setOnClickListener {
            showCustomeDialogBox()
        }
        binding.btnJoin.setOnClickListener {
            showCustomeDialogBox()
        }

        binding.btnBack.setOnClickListener {
           startActivity(Intent(this,StartActiivity::class.java))
            finish()
        }

    }


    private fun showCustomeDialogBox() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_inputhost)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnDone: Button = dialog.findViewById(R.id.btnDone)

        btnDone.setOnClickListener {
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        dialog.show()
    }

}