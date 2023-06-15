package com.mwangi.contactlist

import android.content.Intent
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

    override fun onResume() {
        super.onResume()
        displayContact()

        binding.faAddContact.setOnClickListener {
            val intent = Intent(this, AddContacts::class.java)
            startActivity(intent)
        }
    }

    fun displayContact(){
        var contactOne = ContactsData("https://images.unsplash.com/photo-1542727313-4f3e99aa2568?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80", "Esther Mwangi", "0701378809", "esthermwangi@gmail.com")
        var contactTwo = ContactsData("https://images.unsplash.com/photo-1517598024396-46c53fb391a1?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=435&q=80", "John Doe", "0701568009", "johndoe@gmail.com")
        var contactThree = ContactsData("https://images.unsplash.com/photo-1606914707708-5180546f153d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=388&q=80", "Riley Bina", "0909372801", "esthermwangi@gmail.com")
        var contactFour = ContactsData("https://images.unsplash.com/photo-1527203561188-dae1bc1a417f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=415&q=80", "Jennifer Lawrence", "0501775839", "jenifferlawrence@gmail.com")
        var contactFive = ContactsData("https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80", "Njoro Uba", "0723164520", "njorowauba@gmail.com")
        var contactSix = ContactsData("https://images.unsplash.com/photo-1620000617482-821324eb9a14?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80", "Sankara Mundia", "09642169421", "sankaram@gmail.com")
        var contactSeven = ContactsData("https://images.unsplash.com/photo-1519456264917-42d0aa2e0625?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80", "Mwadime Mwajuma", "0944669421", "mwadimem@gmail.com")
        var contactEight = ContactsData("https://images.unsplash.com/photo-1474176857210-7287d38d27c6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80", "Cecilia Gakii", "02835431830", "gakiicecil@gmail.com")
        var contactNine = ContactsData("https://images.unsplash.com/photo-1463453091185-61582044d556?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80", "Zani Njoroge", "098162433748725", "njorozani@gmail.com")
        var contactTen = ContactsData("https://images.unsplash.com/photo-1544723795-3fb6469f5b39?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=389&q=80", "Stephanie Ike", "0193641739", "ikeokafor@gmail.com")

        var contactsList = listOf<ContactsData>(contactOne, contactTwo, contactThree, contactFour, contactFive, contactSix, contactSeven, contactEight, contactNine, contactTen)
        binding.rvNames.layoutManager = LinearLayoutManager(this)
        val contactsAdapter = ContactsRvAdapter(contactsList)
        binding.rvNames.adapter = contactsAdapter
    }
}