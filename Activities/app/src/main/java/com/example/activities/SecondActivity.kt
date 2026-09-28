package com.example.activities

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle = intent.extras
        val usuari = bundle?.getString("user")
        val points = bundle?.getInt(MainActivity.PARAM_POINTS)

        findViewById<EditText>(R.id.userEditText).setText(usuari)
        findViewById<EditText>(R.id.pointsEditText).setText(points.toString())
    }
}