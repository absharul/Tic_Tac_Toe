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
import java.net.ServerSocket
import java.net.Socket

class HostActivity : AppCompatActivity() {

    private lateinit var serverSocket: ServerSocket
    private lateinit var clientSocket: Socket
    private lateinit var outputStream: OutputStream
    private lateinit var inputStream: InputStream
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)

//        try {
//            // Create a ServerSocket and accept a client connection
//            serverSocket = ServerSocket(8888)
//            clientSocket = serverSocket.accept()
//
//            // Get input and output streams for communication
//            outputStream = clientSocket.getOutputStream()
//            inputStream = clientSocket.getInputStream()
//
//            // Start listening for incoming messages
//            startListening()
//        } catch (e: IOException) {
//            e.printStackTrace()
//            // Log the error message for more information
//            Log.e("HostActivity", "Error accepting client connection: ${e.message}")
//
//            // Handle the exception here (e.g., show an error message)
//        }
        runBlocking {
            launch(Dispatchers.IO) {
                try {
                    // Create a ServerSocket and accept a client connection
                    serverSocket = ServerSocket(8888)
                    clientSocket = serverSocket.accept()
                    // Rest of your code
                } catch (e: IOException) {
                    e.printStackTrace()
                    Log.e("HostActivity", "Error accepting client connection: ${e.message}")
                    // Handle the exception here (e.g., show an error message)
                }
            }
        }

        outputStream = clientSocket.getOutputStream()
        inputStream = clientSocket.getInputStream()

        startListening()


    }

    private fun startListening() {
        TODO("Not yet implemented")
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
                    e.printStackTrace()
                    break // Break the loop on exception
                }
            }
        }
        backgroundThread.start()
    }

    private fun processReceivedMove(receivedMessage: String) {
        val moveParts = receivedMessage.split(",")

        if (moveParts.size == 2) {
            val row = moveParts[0].toIntOrNull()
            val col = moveParts[1].toIntOrNull()

            if (row != null && col != null) {
                // Assuming you have a game board, update it based on the received move
                // Example: updateGameBoard(row, col)
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