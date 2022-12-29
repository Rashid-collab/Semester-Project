package com.example.employee_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast

class MainPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

    }

    fun gotoEmployee_list(view: View)
    {
        var intent = Intent(this,Employee_List::class.java)
        startActivity(intent)
        var toast = Toast.makeText(applicationContext,"Employee List Page", Toast.LENGTH_SHORT).show()
    }

    fun gotoAddEmployee(view: View)
    {
        var intent = Intent(this,AddEmployee::class.java)
        startActivity(intent)
        var toast = Toast.makeText(applicationContext,"Add Employee Page", Toast.LENGTH_SHORT).show()
    }
}