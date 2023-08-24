package com.mwangi.contactlist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mwangi.contactlist.databinding.ActivityMainBinding
import com.mwangi.contactlist.model.ContactsData
import com.mwangi.contactlist.viewmodel.ContactViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactsViewModel: ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.getContacts().observe(this, Observer { contacts->displayContact(contacts) })


        binding.faAddContact.setOnClickListener {
            val intent = Intent(this, AddContacts::class.java)
            startActivity(intent)
        }
    }

    fun displayContact(contactsList: List<ContactsData>){
        val contactsAdapter = ContactsRvAdapter(contactsList, this)
        binding.rvNames.layoutManager = LinearLayoutManager(this)
        binding.rvNames.adapter = contactsAdapter
    }
}