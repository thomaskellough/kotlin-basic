package com.kellough.tiptime

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kellough.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val initialCost = binding.costOfServiceEditText.text.toString().toDoubleOrNull()
        if(initialCost == null) {
            val toast = Toast.makeText(this,"Please enter an initial amount.", Toast.LENGTH_SHORT)
            toast.show()
            binding.tipResult.text = ""
            return
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tipAmount = initialCost * tipPercentage
        if(binding.roundUpSwitch.isChecked)
            tipAmount = kotlin.math.ceil(initialCost * tipPercentage)

        displayTip(tipAmount)
    }

    private fun displayTip(tip: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}