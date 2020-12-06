package com.kellough.affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kellough.affirmations.adapter.ItemAdapter
import com.kellough.affirmations.data.DataSource
import com.kellough.affirmations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dataset = DataSource().loadAffirmations()
        binding.affirmationsRecyclerView.adapter = ItemAdapter(this, dataset)
        binding.affirmationsRecyclerView.setHasFixedSize(true) // only used for performance - do not use if you you need different sizes
    }
}
