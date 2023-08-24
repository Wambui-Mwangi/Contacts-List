package com.mwangi.contactlist.ui

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mwangi.contactlist.R
import com.mwangi.contactlist.databinding.ActivityContactDetailsBinding
import com.mwangi.contactlist.model.ContactsData
import com.mwangi.contactlist.viewmodel.ContactViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactDetailsActivity : AppCompatActivity() {
    var contactId = 0
    lateinit var binding: ActivityContactDetailsBinding
    val contactViewModel: ContactViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactId = intent.getIntExtra("CONTACT_ID", 0)
        contactViewModel.getContactById(contactId).observe(this) { contact ->
            if (contact != null) {
                displayContactDetails(contact)
            } else {
                Toast.makeText(this, "Contact Details Not Found", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun displayContactDetails(contact:ContactsData){
        binding.tvname.text = contact.name
        binding.tvphone.text = contact.phoneNumber
        binding.tvemail.text = contact.emailAddress

        if (contact.avatar.isNotBlank()) {
            Picasso
                .get()
                .load(contact.avatar)
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .into(binding.ivphoto)
        }
    }



}