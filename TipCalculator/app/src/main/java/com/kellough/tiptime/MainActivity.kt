package com.kellough.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kellough.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val initialCost = binding.costOfService.text.toString().toDouble()
        val tipIndex = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (tipIndex) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tipAmount = initialCost * tipPercentage
        if(binding.roundUpSwitch.isChecked)
            tipAmount = kotlin.math.ceil(initialCost * tipPercentage)

        var formattedTip = NumberFormat.getCurrencyInstance().format(tipAmount)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}