package com.example.lab_4_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tv_meal:TextView
    private lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_meal = findViewById<TextView>(R.id.tv_meal)
        btn = findViewById<Button>(R.id.btn_choice)
        btn.setOnClickListener(){
            startActivityForResult(Intent(this,
                MainActivity2::class.java),1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return

        if (requestCode == 1) {
            if (resultCode == 101) {
                val b = data.extras!!
                val str1 = b.getString("drink")
                val str2 = b.getString("sugar")
                val str3 = b.getString("ice")
                tv_meal.text = String.format(
                    "飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n",
                    str1, str2, str3
                )
            }
        }
    }
}