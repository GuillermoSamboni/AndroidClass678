package com.gsamdev.primeraaplicacion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.gsamdev.primeraaplicacion.data.SharedPreferencesManager
import com.gsamdev.primeraaplicacion.databinding.ActivitySegundaBinding
import com.gsamdev.primeraaplicacion.utils.Constants

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
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnLogout.setOnClickListener {
            sharedPref.removeSharedPref(Constants().isLoggedKey)
        }
    }

    private fun setupExtras() {
        userExtra = intent.getStringExtra("keyUser").toString()
        passExtra = intent.getStringExtra("keyPass").toString()

        setupPrintUI()
    }


    private fun setupPreferences() {
        val user = sharedPref.getPref(Constants().userNameKey, Constants().defaultValue).toString()
        Toast.makeText(this, user, Toast.LENGTH_SHORT).show()
    }

    private fun setupPrintUI() {
        binding.txtUser.text = userExtra
        binding.txtPass.text = passExtra
    }

}