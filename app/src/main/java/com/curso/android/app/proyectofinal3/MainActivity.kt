package com.curso.android.app.proyectofinal3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.proyectofinal3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Referencia al ViewModel
    private lateinit var viewModel: TextCompareViewModel

    // Referencia al binding generado por Data Binding
    private lateinit var binding:  ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar el ViewModel usando el ViewModelProvider
        viewModel = ViewModelProvider(this).get(TextCompareViewModel::class.java)

        // Inicializar el binding usando la librería ViewBinding
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Establecer el lifecycle owner del binding para que pueda observar los cambios en el LiveData
        binding.lifecycleOwner = this

        // Establecer el ViewModel del binding para que pueda acceder a sus propiedades y funciones
        binding.viewModel = viewModel

        // Establecer el listener del botón comparar para que llame a la función compareTexts del ViewModel
        binding.buttonCompare.setOnClickListener {
            viewModel.compareTexts(binding.editText1.text.toString(), binding.editText2.text.toString())
        }
    }
}
