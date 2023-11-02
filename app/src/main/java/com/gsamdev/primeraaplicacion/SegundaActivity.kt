package com.gsamdev.primeraaplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.widget.TextView
import android.widget.Toast
import com.gsamdev.primeraaplicacion.data.SharedPreferencesManager
import com.gsamdev.primeraaplicacion.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySegundaBinding
    private lateinit var sharedPref: SharedPreferencesManager


    private lateinit var userExtra: String
    private lateinit var passExtra: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        sharedPref = SharedPreferencesManager(this)

        initUI()

    }

    private fun initUI() {
        setupExtras()
        setupPreferences()
    }

    private fun setupExtras() {
        userExtra = intent.getStringExtra("keyUser").toString()
        passExtra = intent.getStringExtra("keyPass").toString()

        setupPrintUI()
    }


    private fun setupPreferences() {
        val user = sharedPref.getUser()
        Toast.makeText(this, user, Toast.LENGTH_SHORT).show()
    }

    private fun setupPrintUI() {
        binding.txtUser.text = userExtra
        binding.txtPass.text = passExtra
    }

}