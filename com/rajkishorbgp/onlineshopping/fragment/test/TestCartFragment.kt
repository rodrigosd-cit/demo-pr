package com.rajkishorbgp.onlineshopping.fragment.test

import android.widget.ListView
import androidx.fragment.app.testing.launchFragment
import com.rajkishorbgp.onlineshopping.R
import com.rajkishorbgp.onlineshopping.fragment.CartFragment
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TestCartFragment {
    private lateinit var fragment: CartFragment

    @Before
    fun setUp() {
        val scenario = launchFragment<CartFragment>()
        scenario.onFragment { cartFragment ->
            fragment = cartFragment
        }
    }

    @Test
    fun testCartFragmentViewCreated() {
        val listView = fragment.view?.findViewById<ListView>(R.id.listView)
        assertNotNull(listView)
    }
}