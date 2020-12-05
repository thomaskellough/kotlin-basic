package com.kellough.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)

        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val rollTextView: TextView = findViewById(R.id.rollTextView)
        val d6 = Dice(numSides = 6)

        rollTextView.text = d6.roll().toString()
    }
}