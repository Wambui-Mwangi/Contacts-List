package com.mwangi.contactlist.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mwangi.contactlist.model.ContactsData

@Database(entities = arrayOf(ContactsData::class), version = 1)
abstract class ContactsDb: RoomDatabase() {
    abstract fun ContactDao(): ContactDao

    companion object{
        private var database: ContactsDb? = null

        fun getDatabase(context: Context): ContactsDb{
            if (database==null){
                database = Room.databaseBuilder(context, ContactsDb::class.java, "ContactsDb")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as ContactsDb
        }
    }
}
