package com.curso.android.app.proyectofinal3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class TextCompareViewModel : ViewModel() {

    // LiveData para almacenar el modelo de datos
    // textCompareModel solo se puede modificar dentro del ViewModel
    val textCompareModel: LiveData<TextCompareModel> get() = _textCompareModel
    private var _textCompareModel = MutableLiveData<TextCompareModel>()

    // Función para comparar dos textos y actualizar el modelo de datos
    fun compareTexts(text1: String, text2: String) {
        val comparisonResult = when {
            text1.isEmpty() && text2.isEmpty() -> "No se ha ingresado ningún texto" // Esta línea se agrega para indicar si no hay texto
            text1 == text2 -> "Los textos son iguales"
            else -> "Los textos son diferentes"
        }
        _textCompareModel.value = TextCompareModel(text1, text2, comparisonResult)
    }
}
