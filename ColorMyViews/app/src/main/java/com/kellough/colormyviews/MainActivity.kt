package com.kellough.colormyviews

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
            binding.boxOne -> view.setBackgroundResource(R.drawable.image1)
            binding.boxTwo -> view.setBackgroundResource(R.drawable.image2)
            binding.boxThree -> view.setBackgroundResource(R.drawable.image3)
            binding.boxFour -> view.setBackgroundResource(R.drawable.image4)
            binding.boxFive -> view.setBackgroundResource(R.drawable.image5)
            binding.redButton -> view.setBackgroundResource(R.color.my_red)
            binding.greenButton -> view.setBackgroundResource(R.color.my_green)
            binding.yellowButton -> view.setBackgroundResource(R.color.my_yellow)
            else -> view.setBackgroundResource(R.drawable.image6)
        }
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(binding.boxOne, binding.boxTwo,
            binding.boxThree, binding.boxFour, binding.boxFive, binding.root,
            binding.redButton, binding.greenButton, binding.yellowButton)

        for (view in clickableViews) {
            view.setOnClickListener { makeColored(it) }
        }
    }
}