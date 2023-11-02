package com.gsamdev.primeraaplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.gsamdev.primeraaplicacion.data.SharedPreferencesManager
import com.gsamdev.primeraaplicacion.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        sharedPref = SharedPreferencesManager(this)

        val boolean = sharedPref.getBoolean()

        if (boolean) {
            val intent = Intent(this, SegundaActivity::class.java)
            startActivity(intent)
        }

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

            sharedPref.saveBoolean()

            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)
            startActivity(intent)
        }
    }


}