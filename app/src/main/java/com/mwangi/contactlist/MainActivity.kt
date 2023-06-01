package com.mwangi.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mwangi.contactlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun displayContact(){
        var contactOne = ContactsData("", "Esther Mwangi", "0701378809", "esthermwangi@gmail.com")
        var contactTwo = ContactsData("", "John Doe", "0701568009", "johndoe@gmail.com")
        var contactThree = ContactsData("", "Riley Bina", "0909372801", "esthermwangi@gmail.com")
        var contactFour = ContactsData("", "Jennifer Lawrence", "0501775839", "jenifferlawrence@gmail.com")
        var contactFive = ContactsData("", "Njoro Uba", "0723164520", "njorowauba@gmail.com")
        var contactSix = ContactsData("", "Sankara Mundia", "09642169421", "sankaram@gmail.com")
        var contactsList = listOf<ContactsData>(contactOne, contactTwo, contactThree, contactFour, contactFive, contactSix)
        binding.rvNames.layoutManager = LinearLayoutManager(this)
        val contactsAdapter = ContactsRvAdapter(contactsList)
        binding.rvNames.adapter = contactsAdapter
    }
}