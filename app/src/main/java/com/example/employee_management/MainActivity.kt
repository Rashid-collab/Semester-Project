package com.example.employee_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

lateinit var name : TextView
    lateinit var pass : TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        name = findViewById(R.id.textbox)
        pass = findViewById(R.id.pass)
    }

    fun gotomain(view: View)
    {
        if(name.text.toString() =="admin"||name.text.toString() =="Admin" && pass.text.toString()=="admin123"||pass.text.toString()=="Admin123")
        {
            var intent = Intent(this,MainPage::class.java)
            startActivity(intent)
            var toast =Toast.makeText(applicationContext,"Loged IN",Toast.LENGTH_SHORT).show()
        }else
        {
            var toast =Toast.makeText(applicationContext,"Username or Passwrod Mismatched",Toast.LENGTH_SHORT).show()
        }
    }




    }