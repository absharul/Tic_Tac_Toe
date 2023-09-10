package com.example.tictactoe.LAN

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.PopupWindow
import android.widget.Toast
import com.example.tictactoe.R
import com.example.tictactoe.databinding.ActivityMainBinding
import com.example.tictactoe.databinding.ActivityMultiPlayerNetBinding

class MultiPlayerNet : AppCompatActivity() {

    private lateinit var binding : ActivityMultiPlayerNetBinding
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


    }

    private fun showCustomeDialogBox() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_inputhost)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnDone: Button = dialog.findViewById(R.id.btnDone)

        btnDone.setOnClickListener {
          Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        dialog.show()
    }
}