package com.kellough.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kellough.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListeners()
    }

    private fun makeColored(view: View) {
        when (view) {
            binding.boxOne -> view.setBackgroundColor(Color.DKGRAY)
            binding.boxTwo -> view.setBackgroundColor(Color.GRAY)
            binding.boxThree -> view.setBackgroundColor(Color.BLUE)
            binding.boxFour -> view.setBackgroundColor(Color.MAGENTA)
            binding.boxFive -> view.setBackgroundColor(Color.RED)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(binding.boxOne, binding.boxTwo,
                                                binding.boxThree, binding.boxFour,
                                                binding.boxFive, binding.root)

        for (view in clickableViews) {
            view.setOnClickListener { makeColored(it) }
        }
    }
}