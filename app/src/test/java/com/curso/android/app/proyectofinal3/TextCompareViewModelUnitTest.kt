package com.curso.android.app.proyectofinal3

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class TextCompareViewModelUnitTest {
    // Referencia al ViewModel que se va a probar
    private lateinit var viewModel: TextCompareViewModel

    // Regla para ejecutar las tareas en el hilo principal
    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    // Inicializar el ViewModel antes de cada test
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = TextCompareViewModel()
    }
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    // Test para verificar que se indique si no se ha ingresado ningún texto
    @Test
    fun compareTexts_emptyTexts_returnsNoTextMessage() {
        // Arrange: preparar los datos de entrada y salida esperada
        val text1 = ""
        val text2 = ""
        val expected = "No se ha ingresado ningún texto"

        // Act: invocar la función que se va a probar con los datos de entrada
        viewModel.compareTexts(text1, text2)


        // Assert: verificar que el resultado obtenido sea igual al esperado
        assertEquals(expected, viewModel.textCompareModel.value?.comparisonResult)
    }

    // Test para verificar que se indique si los textos son iguales
    @Test
    fun compareTexts_equalTexts_returnsEqualMessage() {
        // Arrange: preparar los datos de entrada y salida esperada
        val text1 = "Hola"
        val text2 = "Hola"
        val expected = "Los textos son iguales"

        // Act: invocar la función que se va a probar con los datos de entrada
        viewModel.compareTexts(text1, text2)

        // Assert: verificar que el resultado obtenido sea igual al esperado
        assertEquals(expected, viewModel.textCompareModel.value?.comparisonResult)
    }

    // Test para verificar que se indique si los textos son diferentes
    @Test
    fun compareTexts_differentTexts_returnsDifferentMessage() {
        // Arrange: preparar los datos de entrada y salida esperada
        val text1 = "Hola"
        val text2 = "Chau"
        val expected = "Los textos son diferentes"

        // Act: invocar la función que se va a probar con los datos de entrada
        viewModel.compareTexts(text1, text2)

        // Assert: verificar que el resultado obtenido sea igual al esperado
        assertEquals(expected, viewModel.textCompareModel.value?.comparisonResult)
    }
}