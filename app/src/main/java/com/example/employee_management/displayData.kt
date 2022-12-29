package com.example.employee_management

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class displayData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)

        var text = findViewById<TextView>(R.id.displayData)
        var data = intent.getStringExtra("data");
        var char = data?.toCharArray()
        var showData = ""
        var counter = 0
        if (char != null) {
            for(i in char){
                if(i==','&& counter ==0){
                    showData += "\n"
                }else{
                    showData += i
                }
            }
        }

        text.text = showData

    }
}