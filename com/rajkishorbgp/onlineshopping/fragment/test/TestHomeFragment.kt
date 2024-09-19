package com.rajkishorbgp.onlineshopping.fragment.test

import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.testing.launchFragment
import androidx.test.core.app.ApplicationProvider
import com.rajkishorbgp.onlineshopping.R
import com.rajkishorbgp.onlineshopping.fragment.HomeFragment
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TestHomeFragment {
    private lateinit var fragment: HomeFragment

    @Before
    fun setUp() {
        val scenario = launchFragment<HomeFragment>()
        scenario.onFragment { homeFragment ->
            fragment = homeFragment
        }
    }

    @Test
    fun testHomeFragmentViewCreated() {
        val listView = fragment.view?.findViewById<ListView>(R.id.listView)
        val toolbarText = (fragment.requireActivity() as MainActivity).findViewById<TextView>(R.id.toolbarText)
        assertEquals("Home", toolbarText.text)
    }
}