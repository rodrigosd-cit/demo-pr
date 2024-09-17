package com.rajkishorbgp.onlineshopping.myclass

import android.content.Context
import com.rajkishorbgp.onlineshopping.HomeDatabase
import com.rajkishorbgp.onlineshopping.ItemClass
import com.rajkishorbgp.onlineshopping.R

class LoadData(context: Context) {
    init {
        val homeArrayList = ArrayList<ItemClass>()
        val itemCartColor = R.color.cart_image_red

        homeArrayList.apply {
            add(ItemClass(
                "iPhone 15 (Blue, 128 GB)",
                "RAM | ROM \n Processor A16 Bionic Chip, 6 Core Processor | Hexa Core \n Front Camera\n48MP + 12MP\n Front Camera\n12MP\nDisplay\n6.1 inch All Screen OLED Display",
                79900,
                R.drawable.iphone15,
                itemCartColor,
                0
            ))

            add(ItemClass(
                "APPLE AirPods Pro",
                "APPLE AirPods Pro (2nd generation) with Active Noise Cancellation, Spatial Audio Bluetooth Headset  (White, True Wireless)",
                24990,
                R.drawable.earbard,
                itemCartColor,
                0
            ))

            add(ItemClass(
                "T-Shirt",
                "Men Printed Round Neck Cotton Blend Black T-Shirt",
                203,
                R.drawable.tshirt,
                itemCartColor,
                0
            ))

            add(ItemClass(
                "Smart Bulb",
                "realme LED Wi-Fi Smart Bulb 9W Smart Bulb",
                884,
                R.drawable.balbe,
                itemCartColor,
                0
            ))

            add(ItemClass(
                "MacBook AIR M2",
                "APPLE 2022 MacBook AIR M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLY13HN/A  (13.6 Inch, Starlight, 1.24 kg)",
                97990,
                R.drawable.macbook,
                itemCartColor,
                0
            ))

            // Add other items similarly...
        }

        val homeDatabase = HomeDatabase(context)
        for (itemClass in homeArrayList) {
            homeDatabase.addData(
                itemClass.itemName,
                itemClass.itemDisc,
                itemClass.prise,
                itemClass.image,
                itemClass.itemCartColor,
                itemClass.isCart
            )
        }
    }
}