package com.example.activities

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val user =  intent.getStringExtra("user")
        val points =  intent.getIntExtra(MainActivity.PARAM_POINTS, 0)

        // ALTERNATIVE

        // val bundle = intent.extras
        // val user = bundle?.getString("user")
        // val points = bundle?.getInt(MainActivity.PARAM_POINTS)

        findViewById<EditText>(R.id.userEditText).setText(user)
        findViewById<EditText>(R.id.pointsEditText).setText(points.toString())
    }
}