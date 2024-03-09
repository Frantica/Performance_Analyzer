package com.bhavani.performanceanalyzer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhavani.performanceanalyzer.data.Employee
import com.bhavani.performanceanalyzer.data.EmployeeUtil
import com.bhavani.performanceanalyzer.databinding.FragmentUserBinding
import com.bhavani.performanceanalyzer.ui.adapter.EmployeesAdapter
import com.bhavani.performanceanalyzer.ui.base.AbsBindingFragment
import java.util.Locale

class UserFragment : AbsBindingFragment<FragmentUserBinding>() {

    private lateinit var employeesAdapter: EmployeesAdapter

    private var employees = emptyList<Employee>() //use MVVM approach to get data

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentUserBinding =
        FragmentUserBinding.inflate(layoutInflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        setupRecyclerView()
        setupSearchView()
    }

    private fun getData() {
        employees = EmployeeUtil.getEmployees()
    }

    private fun setupRecyclerView() {
        viewBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            employeesAdapter = EmployeesAdapter(employees)
            adapter = employeesAdapter
        }
    }

    private fun setupSearchView() {
        viewBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean = filterList(newText)
        })
    }

    //searchView method for filtering list based on entered employee name
    private fun filterList(query: String?) = query?.let { nonNullQuery ->
        val filteredList = employees.filter { it.name.lowercase(Locale.ROOT).contains(nonNullQuery) }
        if (filteredList.isEmpty()) employeesAdapter.clearList()
        else employeesAdapter.setFilteredList(filteredList)
        true
    } ?: false


    companion object {
        fun instance() = UserFragment()
    }

}