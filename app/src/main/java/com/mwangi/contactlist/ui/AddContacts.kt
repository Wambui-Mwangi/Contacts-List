package com.mwangi.contactlist.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.mwangi.contactlist.R
import com.mwangi.contactlist.databinding.ActivityAddContactsBinding
import com.mwangi.contactlist.model.ContactsData
import com.mwangi.contactlist.viewmodel.ContactViewModel

class AddContacts : AppCompatActivity() {
    lateinit var binding:ActivityAddContactsBinding
    val contactsViewModel: ContactViewModel by viewModels()
    val IMAGE_PICK_CODE = 1000
    lateinit var imagePickerLauncher: ActivityResultLauncher<Intent>
    var selectedImageUri: Uri? = null

    val contactList = mutableListOf<ContactsData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_add_contacts)
        setContentView(binding.root)

        imagePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result->
            if (result.resultCode == Activity.RESULT_OK && result.data !=null){
                val imageUri = result.data?.data
                binding.ivPhoto.setImageURI(imageUri)
            }
        }

        binding.addImage.setOnClickListener {
            pickImage()
        }
    }

    fun pickImage(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        imagePickerLauncher.launch(intent)
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
        val avatar = selectedImageUri?.toString()?:""
        var error = false

        if (name.isBlank()){
            binding.tilName.error = getString(R.string.name_required)
            error = true
        }
        else{
            binding.tilName.error = null
        }

        if (phone.isBlank()){
            binding.tilPhoneNumber.error = getString(R.string.phone_number_required)
            error = true
        }
        else{
            binding.tilPhoneNumber.error = null
        }

        if (!error){
            val newContact = ContactsData(contactId = 0, name = name, phoneNumber = phone, emailAddress = email, avatar = avatar)
            contactsViewModel.saveContact(newContact)
            contactList.add(newContact)

//            val adapter = ContactsRvAdapter(contactList, this)

            Toast.makeText(this, "Contact Successfully added", Toast.LENGTH_LONG).show()
            finish()
        }
    }

}