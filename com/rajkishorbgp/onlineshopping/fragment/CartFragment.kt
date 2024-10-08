package com.rajkishorbgp.onlineshopping.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.rajkishorbgp.onlineshopping.CartAdapter
import com.rajkishorbgp.onlineshopping.CartDatabase
import com.rajkishorbgp.onlineshopping.DatabaseHelper
import com.rajkishorbgp.onlineshopping.HomeAdapter
import com.rajkishorbgp.onlineshopping.HomeDatabase
import com.rajkishorbgp.onlineshopping.ItemClass
import com.rajkishorbgp.onlineshopping.R
import java.util.ArrayList

class CartFragment : Fragment() {
    private lateinit var view: View
    private lateinit var cartArrayList: ArrayList<ItemClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_cart, container, false)
        cartArrayList = ArrayList()
        val listView: ListView = view.findViewById(R.id.listView)
        val textItemDesc: TextView = view.findViewById(R.id.textItemDesc)
        val pleaseOrderButton: Button = view.findViewById(R.id.pleaseOrderButton)
        val cartDatabase = CartDatabase(requireContext().applicationContext)
        cartArrayList = cartDatabase.allDataUser

        if (cartArrayList.size == 0) {
            textItemDesc.text = "Cart is Empty"
        }

        val cartAdapter = CartAdapter(requireActivity().applicationContext, cartArrayList)
        val homeDatabase = HomeDatabase(requireActivity().applicationContext)
        listView.adapter = cartAdapter

        pleaseOrderButton.setOnClickListener {
            val updatedCartArrayList = cartDatabase.allDataUser
            for (itemClass in updatedCartArrayList) {
                homeDatabase.updateIsCart(itemClass.itemName, itemClass.isCart, R.color.cart_image_red)
            }
            Toast.makeText(requireActivity().applicationContext, "Your order has successfully placed", Toast.LENGTH_SHORT).show()
            cartDatabase.clear()
            parentFragmentManager.beginTransaction().detach(this@CartFragment).commit()
            parentFragmentManager.beginTransaction().attach(this@CartFragment).commit()
        }
        return view
    }
}