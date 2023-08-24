package com.mwangi.contactlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mwangi.contactlist.model.ContactsData
import com.mwangi.contactlist.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactViewModel: ViewModel() {
    val contactsRepo = ContactsRepository()
    lateinit var contactLiveData: LiveData<ContactsData>

    fun saveContact(contact: ContactsData){
        viewModelScope.launch {
            contactsRepo.saveContact(contact)
        }
    }
    fun getContacts(): LiveData<List<ContactsData>>{
        return contactsRepo.getDbContacts()
    }

    fun getContactById(contactId: Int): LiveData<ContactsData> {
        return contactsRepo.getContactById(contactId)
    }
}