package com.mwangi.contactlist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class ContactsData(
    @PrimaryKey(autoGenerate = true) var contactId: Int,
    var avatar:String,
    var name:String,
    var phoneNumber:String,
    var emailAddress:String,
)
