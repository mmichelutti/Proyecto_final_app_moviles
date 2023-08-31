package com.curso.android.app.proyectofinal3

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    // Regla para lanzar la actividad que se va a probar
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Test para verificar que se muestre el mensaje de no texto si no se ingresa ningún texto
    @Test
    fun compareTexts_emptyTexts_displaysNoTextMessage() {
        // Arrange: preparar los datos de entrada y salida esperada
        val text1 = ""
        val text2 = ""
        val expected = "No se ha ingresado ningún texto"

        // Act: interactuar con la interfaz usando Espresso
        onView(withId(R.id.editText1)).perform(typeText(text1), closeSoftKeyboard())
        onView(withId(R.id.editText2)).perform(typeText(text2), closeSoftKeyboard())
        onView(withId(R.id.buttonCompare)).perform(click())

        // Assert: verificar que se muestre el mensaje esperado en el TextView
        onView(withId(R.id.textViewResult)).check(matches(withText(expected)))
    }

    // Test para verificar que se muestre el mensaje de igualdad si se ingresan textos iguales
    @Test
    fun compareTexts_equalTexts_displaysEqualMessage() {
        // Arrange: preparar los datos de entrada y salida esperada
        val text1 = "Hola"
        val text2 = "Hola"
        val expected = "Los textos son iguales"

        // Act: interactuar con la interfaz usando Espresso
        onView(withId(R.id.editText1)).perform(typeText(text1), closeSoftKeyboard())
        onView(withId(R.id.editText2)).perform(typeText(text2), closeSoftKeyboard())
        onView(withId(R.id.buttonCompare)).perform(click())

        // Assert: verificar que se muestre el mensaje esperado en el TextView
        onView(withId(R.id.textViewResult)).check(matches(withText(expected)))
    }

    // Test para verificar que se muestre el mensaje de diferencia si se ingresan textos diferentes
    @Test
    fun compareTexts_differentTexts_displaysDifferentMessage() {
        // Arrange: preparar los datos de entrada y salida esperada
        val text1 = "Hola"
        val text2 = "Adiós"
        val expected = "Los textos son diferentes"

        // Act: interactuar con la interfaz usando Espresso
        onView(withId(R.id.editText1)).perform(typeText(text1), closeSoftKeyboard())
        onView(withId(R.id.editText2)).perform(typeText(text2), closeSoftKeyboard())
        onView(withId(R.id.buttonCompare)).perform(click())

        // Assert: verificar que se muestre el mensaje esperado en el TextView
        onView(withId(R.id.textViewResult)).check(matches(withText(expected)))
    }
}