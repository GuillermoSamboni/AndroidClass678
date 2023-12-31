package com.gsamdev.primeraaplicacion.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.gsamdev.primeraaplicacion.data.SharedPreferencesManager
import com.gsamdev.primeraaplicacion.databinding.ActivityMainBinding
import com.gsamdev.primeraaplicacion.utils.Constants


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        sharedPref = SharedPreferencesManager(this)

        initUI()
    }

    private fun initUI() {
        setupOnClickListener()
    }

    private fun setupOnClickListener() {

        binding.txtRecoverPass.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {

            val user = binding.txtUser.text.toString()
            val pass = binding.txtPass.text.toString()
            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("keyUser", user)
            intent.putExtra("keyPass", pass)

            //sharedPref.saveBoolean()

            sharedPref.savePref(Constants().isLoggedKey, true)
            sharedPref.savePref(Constants().userNameKey, user)
            sharedPref.savePref(Constants().passUserKey, pass)

            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)
            startActivity(intent)
        }
    }


}