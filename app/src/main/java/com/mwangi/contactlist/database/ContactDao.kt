package com.mwangi.contactlist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mwangi.contactlist.model.ContactsData

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact:ContactsData)

    @Query("SELECT * FROM Contacts ORDER BY NAME")
    fun getAllContacts():LiveData<List<ContactsData>>

    @Query("SELECT * FROM Contacts WHERE contactId = :contactId")
    fun getContactById(contactId:Int): LiveData<ContactsData>
}