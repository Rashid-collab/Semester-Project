package com.example.employee_management

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AddEmployee : AppCompatActivity() {
    var DBNAME = "EmployeeData"
    lateinit var db: SQLiteDatabase
    var Table_name = "Employee"
    val emp_Name :String ="employee_Name"
    val emp_designation : String = "employee_Designation"
    val emp_salary : String = "employee_Salary"
    lateinit var setname : EditText
    lateinit var setdesignation:EditText
    lateinit var setsalary : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)


        setname = findViewById(R.id.name)
        setdesignation = findViewById(R.id.designation)
        setsalary = findViewById(R.id.salary)

        db = openOrCreateDatabase(DBNAME, MODE_PRIVATE, null)

        val tableQuery =
            "CREATE TABLE IF NOT EXISTS $Table_name(id Integer PRIMARY KEY AUTOINCREMENT, $emp_Name TEXT, $emp_designation TEXT, $emp_salary TEXT)"

        db.execSQL(tableQuery)


    }

    fun onlick(view: View)
    {
        var cv = ContentValues()
        cv.put(emp_Name,setname.text.toString())
        cv.put(emp_designation,setdesignation.text.toString())
        cv.put(emp_salary,setsalary.text.toString())


        var toast = Toast.makeText(applicationContext,"Employee Added Successfully", Toast.LENGTH_SHORT).show()
        var name = findViewById<TextView>(R.id.name)
        var designation = findViewById<TextView>(R.id.designation)
        var salary = findViewById<TextView>(R.id.salary)

        name.text = ""
        designation.text=""
        salary.text=""

        db.insert(Table_name,null,cv)
    }
}