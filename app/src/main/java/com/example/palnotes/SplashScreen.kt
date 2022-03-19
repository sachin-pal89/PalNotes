package com.example.palnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // To hide action bar in splash screen
        supportActionBar?.hide()

        // To move to main activity after splash screen shown for 2sec
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            //code
            startActivity(Intent(this, MainActivity::class.java))
        }, 5000)
    }
}