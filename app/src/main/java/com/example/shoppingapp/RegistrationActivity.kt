package com.example.shoppingapp

import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

import com.example.shoppingapp.network.User


class RegistrationActivity : AppCompatActivity() {
    private var etName: EditText? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var etUserName: EditText? = null
    private var etCity: EditText? = null
    private var etAddress: EditText? = null
    private var etPhoneNumber: EditText? = null
    private var genderRadioGroup: RadioGroup? = null
    private var selectedGender: RadioButton? = null
    private lateinit var gender: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        etUserName = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        etAddress = findViewById(R.id.et_address)
        etCity = findViewById(R.id.et_City)
        etPhoneNumber = findViewById(R.id.et_phoneNumber)


        val btnSave = findViewById<Button>(R.id.save_btn)


        btnSave.setOnClickListener {
            saveToDatabase()

        }
    }


    private fun saveToDatabase() {
        val name = etName?.text.toString()
        val email = etEmail?.text.toString()
        val password = etPassword?.text.toString()
        val address = etAddress?.text.toString()
        val city = etCity?.text.toString()
        val phoneNumber = etPhoneNumber?.text.toString()
        val userName = etUserName?.text.toString()


        val selectedRadioButtonId: Int = genderRadioGroup!!.checkedRadioButtonId



        if (selectedRadioButtonId != -1) {
            selectedGender = findViewById(selectedRadioButtonId)
            gender = selectedGender?.text.toString()

        }


        val user = User(
            name = name,
            email = email,
            password = password,
            userName = userName,
            address = address,
            city = city,
            gender = gender,
            phoneNumber = phoneNumber
        )

    }
}