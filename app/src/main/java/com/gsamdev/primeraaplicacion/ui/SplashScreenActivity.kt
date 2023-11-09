package com.gsamdev.primeraaplicacion.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.gsamdev.primeraaplicacion.R
import com.gsamdev.primeraaplicacion.data.SharedPreferencesManager

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private val TIMER_SPLASH = 3000L
    private lateinit var sharedPref: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = SharedPreferencesManager(this)
        setContentView(R.layout.activity_splash_screen)

        initUI()
    }

    private fun initUI() {
        setupJumpNextActivity()
    }

    private fun setupJumpNextActivity() {

        val userLogged = sharedPref.getUsersIsLogged()

        if (userLogged) {
            Looper.myLooper()?.let {
                Handler(it).postDelayed(
                    {
                        val intent = Intent(this, SegundaActivity::class.java)
                        startActivity(intent)
                    }, TIMER_SPLASH
                )
            }
        } else {
            Looper.myLooper()?.let {
                Handler(it).postDelayed(
                    {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }, TIMER_SPLASH
                )
            }
        }
    }

}