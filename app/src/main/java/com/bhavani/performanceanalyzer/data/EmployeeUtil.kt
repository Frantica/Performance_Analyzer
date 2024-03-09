package com.bhavani.performanceanalyzer.data

object EmployeeUtil {

    fun getEmployees() = mutableListOf<Employee>().apply {
        add(Employee(1, "Arjun", "16-11-2000", "Software Engineer", 1))
        add(Employee(2, "Mahesh", "15-01-2000", "Web Developer", 2))
        add(Employee(3, "Anjali", "20-05-2000", "App Developer", 3))
        add(Employee(4, "Amrita", "31-03-2000", "Salesforce Developer", 4))
    }
}