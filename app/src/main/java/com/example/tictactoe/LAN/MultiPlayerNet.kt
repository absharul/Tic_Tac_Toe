package com.example.tictactoe.LAN

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.R
import com.example.tictactoe.StartActiivity
import com.example.tictactoe.databinding.ActivityMultiPlayerNetBinding

class MultiPlayerNet : AppCompatActivity() {

    private lateinit var binding: ActivityMultiPlayerNetBinding

    private lateinit var listView: TextView
    private lateinit var listView2: TextView
    private lateinit var textList: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMultiPlayerNetBinding.inflate(layoutInflater)

        setContentView(binding.root)

        listView = findViewById(R.id.list_contenthost)
//        textList = mutableListOf()
//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, textList)
//        listView.adapter = adapter

        listView2 = findViewById(R.id.list_contentjoin)
        textList = mutableListOf()
//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, textList)
//        listView.adapter = adapter


        binding.btnHost.setOnClickListener {
            showCustomeDialogBoxHost()
        }
        binding.btnJoin.setOnClickListener {
            showCustomeDialogBoxJoin()
        }

        binding.btnBack.setOnClickListener {
           startActivity(Intent(this,StartActiivity::class.java))
            finish()
        }



    }

    private fun showCustomeDialogBoxHost() {

    val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_inputhost)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    val editText: EditText = dialog.findViewById(R.id.user_editText)



    val btnDone: Button = dialog.findViewById(R.id.btnDone)

        btnDone.setOnClickListener {
//            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
            val text = editText.text.toString()
            if (text.isNotEmpty()) {
                listView.setText(text)
//                adapter.notifyDataSetChanged()
            }
            dialog.dismiss()
        }

    dialog.show()
    }

    private fun showCustomeDialogBoxJoin() {
        TODO("Not yet implemented")
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_inputhost)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val editText: EditText = dialog.findViewById(R.id.user_editText)



        val btnDone: Button = dialog.findViewById(R.id.btnDone)

        btnDone.setOnClickListener {
//            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
            val text = editText.text.toString()
            if (text.isNotEmpty()) {
                listView2.setText(text)
//                adapter.notifyDataSetChanged()
            }
            dialog.dismiss()
        }

        dialog.show()
    }

}