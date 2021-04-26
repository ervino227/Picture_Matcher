package com.example.picturematcher

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
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

    private val imagesMap = mutableMapOf<View, Int>()
    private var image1: Int? = null
    private var image2: Int? = null
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)

        score = 0
        imagesMap.clear()
        images.shuffle()

        val views2 = mutableListOf(
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
            imagesMap[view] = images[index]
            view.setOnClickListener {
                compareImages(it)
            }
            index++
        }
    }

    private fun compareImages(view: View) {
        if (image1 == null) {
            image1 = imagesMap[view]
        }
        else {
            image2 = imagesMap[view]
            if (image1 == image2) {
                Toast.makeText(this,"Found match!",Toast.LENGTH_LONG).show()
                addToScore()
                image1 = null
                image2 = null
            }
            else {
                Toast.makeText(this,"No match", Toast.LENGTH_LONG).show()
                image1 = null
                image2 = null
            }
        }
    }

    private fun addToScore() {
        score++
        val myScore = findViewById<TextView>(R.id.score_view)
        myScore.text = "$score / 6 matches"
    }
}