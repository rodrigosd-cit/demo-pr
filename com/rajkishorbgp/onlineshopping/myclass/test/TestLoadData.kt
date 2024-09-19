package com.rajkishorbgp.onlineshopping.myclass.test

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.rajkishorbgp.onlineshopping.myclass.LoadData
import org.junit.Before
import org.junit.Test

class TestLoadData {
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun testLoadDataInitialization() {
        LoadData(context)
        // Further assertions can be added to check data in database
    }
}