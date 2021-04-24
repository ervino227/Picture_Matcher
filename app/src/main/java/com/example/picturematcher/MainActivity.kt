package com.example.picturematcher

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.picturematcher.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

private val images = mutableListOf<Int>(
    R.drawable.diamond_image,
    R.drawable.diamond_image,
    R.drawable.moon_image,
    R.drawable.moon_image,
    R.drawable.house_image,
    R.drawable.house_image,
    R.drawable.star_image,
    R.drawable.star_image,
    R.drawable.sun_image,
    R.drawable.sun_image,
    R.drawable.target_image,
    R.drawable.target_image
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)

        images.shuffle()

        var views2 = mutableListOf(
            binding.view1,
            binding.view2,
            binding.view3,
            binding.view4,
            binding.view5,
            binding.view6,
            binding.view7,
            binding.view8,
            binding.view9,
            binding.view10,
            binding.view11,
            binding.view12
        )

        var index = 0
        for (view in views2) {
            view.setImageResource(images[index])
            index++
        }
    }
}