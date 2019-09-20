package com.example.mymsgapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            Toast.makeText(this, "Show Toast was clicked", Toast.LENGTH_LONG).show()
        }
        btnSendMsg.setOnClickListener {
            val message = msgtext.text.toString()
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()

            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("user_message",message)
            startActivity(intent)
        }
        btnShareToApp.setOnClickListener {
            val message = msgtext.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share Message To:..."))
        }
    }
}