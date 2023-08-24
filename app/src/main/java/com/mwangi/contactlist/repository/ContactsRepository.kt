package com.mwangi.contactlist.repository

import androidx.lifecycle.LiveData
import com.mwangi.contactlist.ContactListApp
import com.mwangi.contactlist.database.ContactsDb
import com.mwangi.contactlist.model.ContactsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDb.getDatabase(ContactListApp.appContext)

    suspend fun saveContact(contact: ContactsData){
        return withContext(Dispatchers.IO){
            database.ContactDao().insertContact(contact)
        }
    }

    fun getDbContacts():LiveData<List<ContactsData>>{
        return database.ContactDao().getAllContacts()
    }

    fun getContactById(contactId:Int): LiveData<ContactsData>{
        return database.ContactDao().getContactById(contactId)
    }
}