package com.carlostena.mislisteners

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.carlostena.mislisteners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    var numeroDeHolas = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bDecirHola.setOnClickListener {
            Toast.makeText(this, "Hola!", Toast.LENGTH_LONG).show()
            binding.tvHola.text = "Hola ${numeroDeHolas++}"
        }

        binding.etUno.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus){
                println("Soy etUno y tengo el focus")
            } else {
                println("Soy etUno y no tengo el focus")
            }
        }

        binding.etDos.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus){
                println("Soy etDos y tengo el focus")
            } else {
                println("Soy etDos y no tengo el focus")
            }
        }

        binding.etDos.doOnTextChanged { text, start, before, count ->
            if (text.contentEquals("Hola")) {
                Toast.makeText(this, "Hola a ti tb", Toast.LENGTH_LONG).show()
            }
        }
    }
}