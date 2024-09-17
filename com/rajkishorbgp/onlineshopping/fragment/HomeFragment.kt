package com.rajkishorbgp.onlineshopping.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import com.rajkishorbgp.onlineshopping.DatabaseHelper
import com.rajkishorbgp.onlineshopping.HomeAdapter
import com.rajkishorbgp.onlineshopping.HomeDatabase
import com.rajkishorbgp.onlineshopping.ItemClass
import com.rajkishorbgp.onlineshopping.MainActivity
import com.rajkishorbgp.onlineshopping.R
import com.rajkishorbgp.onlineshopping.myclass.LoadData

class HomeFragment : Fragment() {
    private lateinit var view: View
    private lateinit var homeArrayList: ArrayList<ItemClass>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.fragment_home, container, false)
        val listView: ListView = view.findViewById(R.id.listView)

        val homeDatabase = HomeDatabase(requireActivity().applicationContext)
        homeArrayList = homeDatabase.getAllDataUser()

        val homeAdapter = HomeAdapter(requireActivity().applicationContext, homeArrayList)
        listView.adapter = homeAdapter
        
        return view
    }

    override fun onResume() {
        super.onResume()
        val activity = requireActivity() as MainActivity
        val toolbarText: TextView = activity.findViewById(R.id.toolbarText)
        toolbarText.text = "Home"
    }
}