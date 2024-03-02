package com.bhavani.performanceanalyzer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhavani.performanceanalyzer.R
import com.bhavani.performanceanalyzer.adapter.Items
import com.bhavani.performanceanalyzer.adapter.ItemsAdapter
import java.util.Locale

class UserFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var itemList = ArrayList<Items>()
    private lateinit var adapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        addDataToList()
        adapter = ItemsAdapter(itemList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    //searchView method for filtering list based on entered employee name
    private fun filterList(query:String?){
        if (query!=null){
            val filteredList = ArrayList<Items>()
            for (i in itemList){
                if (i.name.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()) {
                adapter.clearList()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList(){
        itemList.add(Items(1, "Arjun", "16-11-2000", "Software Engineer", 1))
        itemList.add(Items(2,"Mahesh", "15-01-2000", "Web Developer", 2))
        itemList.add(Items(3,"Anjali", "20-05-2000", "App Developer", 3))
        itemList.add(Items(4,"Amrita", "31-03-2000", "Salesforce Developer", 4))
    }
}