package com.example.activities

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EnterNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_name)
    }

    fun onClickOkButton(view: View) {
        intent.putExtra("name", findViewById<EditText>(R.id.nameEditText).text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }

    fun onClickCancelButton(view: View) {
        setResult(RESULT_CANCELED, intent)
        finish()
    }
}