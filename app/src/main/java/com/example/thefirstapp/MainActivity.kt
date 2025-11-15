package com.example.thefirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val admin = findViewById<Button>(R.id.ButtonAdmin)
        val InputAdmin = findViewById<EditText>(R.id.editText);
        admin.setOnClickListener{
           if(InputAdmin.text.toString() == "19614141"){
               Toast.makeText(this, "Вы вошли как админ", Toast.LENGTH_SHORT).show()
               val intent = Intent(this, DB_Activity::class.java)
               startActivity(intent);
           }else{
               Toast.makeText(this, "Неверный пароль", Toast.LENGTH_SHORT).show()
               InputAdmin.text = null;
           }
        }
    }
}