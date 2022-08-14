package com.example.shoppingapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.shoppingapp.network.User
import com.ntgclarity.authenticator.database.User
import com.ntgclarity.authenticator.database.UsersDatabase

class RegistrationActivity : AppCompatActivity() {
    var etName: EditText? = null
    var etEmail: EditText? = null
    var etPassword: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        etName = findViewById<EditText>(R.id.et_name)
        etEmail = findViewById<EditText>(R.id.et_email)
        etPassword = findViewById<EditText>(R.id.et_password)

        val btnSave = findViewById<Button>(R.id.btn_save)


        btnSave.setOnClickListener {
            saveToDatabase()

        }
    }


    fun saveToDatabase() {
        val name = etName?.text.toString()
        val email = etEmail?.text.toString()
        val password = etPassword?.text.toString()

        val user = User(name = name, email = email, password = password)

    }
}