package com.example.tictactoe.LAN

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tictactoe.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.Socket

class ClientActivity : AppCompatActivity() {


    private lateinit var clientSocket: Socket
    private lateinit var outputStream: OutputStream
    private lateinit var inputStream: InputStream

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)


        val hostIpAddress = intent.getStringExtra("HOST_IP_ADDRESS")
//        clientSocket = Socket(hostIpAddress, 8888)
//
//        outputStream = clientSocket.getOutputStream()
//        inputStream = clientSocket.getInputStream()
//        startListening()
        runBlocking {
            launch(Dispatchers.IO) {
                try {
                    clientSocket = Socket(hostIpAddress, 8888)
                    // Rest of your code
                } catch (e: IOException) {
                    e.printStackTrace()
                    Log.e("ClientActivity", "Error creating socket: ${e.message}")
                    // Handle the exception here (e.g., show an error message)
                }
            }
        }

        outputStream = clientSocket.getOutputStream()
        inputStream = clientSocket.getInputStream()

        startListening()

    }
    private fun startListening() {
        // Implement a background thread to continuously listen for moves
        val backgroundThread = Thread {
            while (!Thread.currentThread().isInterrupted) {
                try {
                    val buffer = ByteArray(1024)
                    val bytesRead = inputStream.read(buffer)
                    val receivedMessage = buffer.copyOf(bytesRead).toString(Charsets.UTF_8)

                    // Process the received move
                    processReceivedMove(receivedMessage)
                } catch (e: IOException) {
                    // Handle exceptions such as connection errors
                }
            }
        }
        backgroundThread.start()
    }

    private fun processReceivedMove(receivedMessage: String) {
        // Assuming the received message is in the format "row,col" as in your host code
        val moveParts = receivedMessage.split(",")

        if (moveParts.size == 2) {
            // Extract row and column from moveParts
            val row = moveParts[0].toIntOrNull()
            val col = moveParts[1].toIntOrNull()

            if (row != null && col != null) {
                // Now you have valid row and column values
                // You can use them to update your game board or perform other actions
            } else {
                // Handle the case where the received message is not in the expected format
            }
        } else {
            // Handle the case where the received message does not contain two parts
        }
    }

    private fun sendMove(move: String) {
        try {
            outputStream.write(move.toByteArray())
            outputStream.flush()
        } catch (e: IOException) {
            // Handle exceptions related to sending data
        }
    }

}