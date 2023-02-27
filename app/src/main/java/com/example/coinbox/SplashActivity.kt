package com.example.coinbox

import android.R
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ncorti.slidetoact.SlideToActView


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.coinbox.R.layout.splash_activity)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        supportActionBar?.hide()
        val sta = findViewById<SlideToActView>(com.example.coinbox.R.id.slider)
        sta.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener{
            override fun onSlideComplete(view: SlideToActView) {
                var intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
            }

        }
// Set the fitsSystemWindows property to true


    }
}