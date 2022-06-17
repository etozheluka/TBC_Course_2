package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        click()

    }

    private fun click() {
        button.setOnClickListener {
            val text = NumberToWords
            val value: String = editTextNumber.text.toString()
            if (value.isNotEmpty()) {
                val finalValue = value.toInt()
                val s = text.convert(finalValue)
                textView.text = s
            } else {
                textView.text = "გთხოვთ შეიყვანეთ რიცხვი"
            }
        }
    }
}



