package com.mwangi.contactlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mwangi.contactlist.databinding.ActivityAddContactsBinding

class AddContacts : AppCompatActivity() {
    lateinit var binding:ActivityAddContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_add_contacts)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btAddContact.setOnClickListener {
            validateAddContact()
        }

    }

    fun validateAddContact(){
        val name = binding.etName.text.toString()
        val email = binding.etEmailAddress.text.toString()
        val phone = binding.etPhoneNumber.text.toString()
        var error = false

        if (name.isBlank()){
            binding.tilName.error = "Name field cannot be empty"
            error = true
        }

        if (phone.isBlank()){
            binding.tilPhoneNumber.error = "Phone number field cannot be empty"
            error = true
        }

        if (!error){
            Toast.makeText(this, "Contact Successfully added", Toast.LENGTH_LONG).show()
        }
    }
}