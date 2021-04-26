package com.example.picturematcher

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
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

    @RequiresApi(Build.VERSION_CODES.M)
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


    var view1: View? = null
    var view2: View? = null
    val handler = Handler()
    @RequiresApi(Build.VERSION_CODES.M)
    private fun compareImages(view: View) {
        if (image1 == null) {
            view1 = view
            view1?.foreground = null
            image1 = imagesMap[view]
            //Thread.sleep(500)
        }
        else {
            view2 = view
            view2?.foreground = null
            image2 = imagesMap[view]
            if (image1 == image2) {
                Toast.makeText(this,"Found match!",Toast.LENGTH_SHORT).show()
                addToScore()
                image1 = null
                image2 = null
            }
            else {
                Toast.makeText(this,"No match", Toast.LENGTH_SHORT).show()
                handler.postDelayed({
                    view1?.foreground = resources.getDrawable(R.drawable.forground_image)
                    view2?.foreground = resources.getDrawable(R.drawable.forground_image)
                                    },1000)
                image1 = null
                image2 = null
            }
        }
    }

    private fun addToScore() {
        score++
        val myScore = binding.scoreView
        myScore.text = "$score / 6 matches"
    }
}