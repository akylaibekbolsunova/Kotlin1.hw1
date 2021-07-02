package com.example.kotlin1hw1.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1hw1.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        checkIntent()
        setUpListener()
    }

    private fun setUpListener(){
        send_btn2.setOnClickListener {
            if (!input_et2.text.isNullOrEmpty()) sent()
        }
    }

    private fun sent(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("TEXT",input_et2.text.toString())
        setResult(Activity.RESULT_OK,intent)
        finish()
    }

    private fun checkIntent(){
        val text: String? = intent.getStringExtra("TEXT")
        input_et2.setText(text)
    }
}