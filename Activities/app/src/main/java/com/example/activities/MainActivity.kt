package com.example.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        val PARAM_POINTS = "points"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.signButton).setOnClickListener {
            signAction()
        }

        findViewById<Button>(R.id.sendButton).setOnClickListener {
           sendAction()
        }

        findViewById<Button>(R.id.secondButton).setOnClickListener {
            secondAction()
        }
    }
    private fun signAction() {
        startActivity(Intent(this, SignActivity::class.java))
    }
    private fun sendAction() {
        startActivity(
            Intent(Intent.ACTION_SEND).apply {
                // The intent does not have a URI, so declare the "text/plain" MIME type
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("jan@example.com")) // recipients
                putExtra(Intent.EXTRA_SUBJECT, "Email subject")
                putExtra(Intent.EXTRA_TEXT, "Email message text")
                putExtra(
                    Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment")
                )
                // You can also attach multiple items by passing an ArrayList of Uris
            })
    }

    private fun secondAction() {
        startActivity(
            Intent(this, SecondActivity::class.java).apply {
                putExtra(
                    "user", findViewById<EditText>(R.id.user).getText().toString()
                )
                putExtra(PARAM_POINTS, 18)
            })
    }
}