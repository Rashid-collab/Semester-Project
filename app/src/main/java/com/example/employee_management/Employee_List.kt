package com.example.employee_management

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout

class Employee_List : AppCompatActivity() {
    var DBNAME = "EmployeeData"
    lateinit var db: SQLiteDatabase
    var Table_name = "Employee"
    val emp_Name :String ="employee_Name"
    val emp_designation : String = "employee_Designation"
    val emp_salary : String = "employee_Salary"
    lateinit var stringArray : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)

        stringArray = ArrayList<String>()

        db = openOrCreateDatabase(DBNAME, MODE_PRIVATE, null)

        val tableQuery =
            "CREATE TABLE IF NOT EXISTS $Table_name(id Integer PRIMARY KEY AUTOINCREMENT, $emp_Name TEXT, $emp_designation TEXT, $emp_salary TEXT)"

        db.execSQL(tableQuery)
        onGetData()


        var list : ListView = findViewById(R.id.listview)
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stringArray)
        list.adapter = adapter
        list.setOnItemClickListener { parent, view, position, id ->
            var tmp = onGetData((position+1).toString())
            var intent = Intent(this, displayData::class.java)
            intent.putExtra("data",tmp)
            startActivity(intent)
        }

    }

    fun onGetData(id: String): String{

        val query = "SELECT  * FROM $Table_name WHERE id=$id"
        val cursor : Cursor = db.rawQuery(query,null)
        var data = ""
        cursor.moveToNext()
        data = cursor.getString(0).toString()+","+cursor.getString(1).toString()+","+cursor.getString(2).toString()+","+cursor.getString(3).toString()
        return data
    }


    fun onGetData(): String{
          val query = "SELECT  * FROM $Table_name"
            val cursor : Cursor = db.rawQuery(query,null)
            var data = ""
            if(cursor.count>0){
                cursor.moveToFirst()
                do{
//                        data += cursor.getString(0).toString()+","+cursor.getString(1).toString()+","+cursor.getString(2).toString()+","+cursor.getString(3).toString()+"\n"
                    data = cursor.getString(1)
                    stringArray.add(data)

                }while(cursor.moveToNext())
            }
            return data
    }

//    fun onListClick(view: View){
//        var name = view.
//    }

}