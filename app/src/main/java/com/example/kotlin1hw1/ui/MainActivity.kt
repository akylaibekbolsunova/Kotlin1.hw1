package com.example.kotlin1hw1.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin1hw1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForResult()
        setUpListener()
    }

    private fun registerForResult() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    input_et.setText(result.data?.getStringExtra("TEXT"))
                }
            }
    }

    private fun setUpListener() {
        send_btn.setOnClickListener {
            if (!input_et.text.isNullOrEmpty()) sent()
            else Toast.makeText(this, "Field is can not be empty", Toast.LENGTH_SHORT)
        }
    }

    private fun sent() {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("TEXT", input_et.text.toString())
        resultLauncher.launch(intent)
    }
}