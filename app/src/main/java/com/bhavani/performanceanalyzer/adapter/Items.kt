package com.bhavani.performanceanalyzer.adapter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

data class Items(val empId: Int, val name: String, val dob: String, val role: String, val num: Int)

//Reading data from json file
fun main() {
    val jsonString = File("items.json").readText()
    val itemsListType = object : TypeToken<List<Items>>() {}.type
    val itemsList: List<Items> = Gson().fromJson(jsonString, itemsListType)

    itemsList.forEach { item ->
        println("Employee ID: ${item.empId}")
        println("Name: ${item.name}")
        println("Date of Birth: ${item.dob}")
        println("Role: ${item.role}")
        println("Number: ${item.num}")
        println()
    }
}

