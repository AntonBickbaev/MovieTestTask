package com.project.asmv.movietesttask

import org.junit.Before
import org.mockito.MockitoAnnotations
import java.io.IOException

open class BaseTest {


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    fun loadJSONFromAsset(aClass: Any, fileName: String): String? {
        var json: String? = null
        try {
            val inputStream = aClass.javaClass.classLoader?.getResourceAsStream(fileName)
            json = inputStream?.bufferedReader().use { it?.readText() }
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }
}