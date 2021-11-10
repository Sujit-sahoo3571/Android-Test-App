package com.futurebrains.testingappsplashscreen.ui.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.futurebrains.testingappsplashscreen.MainActivity
import com.futurebrains.testingappsplashscreen.R
import com.futurebrains.testingappsplashscreen.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    lateinit var binding: ActivitySplashScreenBinding
    private val SPLASHSCREEN_TIME: Long = 3000

    lateinit var topanimation: Animation
    lateinit var bottomanimation: Animation

    //    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        handler = Handler()

        topanimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomanimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)


        binding.splashImg.animation = topanimation
        binding.splashTitle.animation = bottomanimation
        binding.desc.animation = bottomanimation

        Handler().postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASHSCREEN_TIME)


    }
}