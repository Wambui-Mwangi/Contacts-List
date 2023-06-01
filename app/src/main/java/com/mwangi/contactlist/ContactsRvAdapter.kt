package com.mwangi.contactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mwangi.contactlist.databinding.ActivityMainBinding
import com.mwangi.contactlist.databinding.ContactsListItemBinding

class ContactsRvAdapter(var contactList:List<ContactsData>):RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding = ContactsListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var contact = contactList[position]
        holder.binding.tvName.text = contact.name
        holder.binding.tvEmailAddress.text = contact.emailAddress
        holder.binding.tvPhoneNumber.text = contact.phoneNumber.toString()
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

class  ContactsViewHolder(var binding: ContactsListItemBinding): RecyclerView.ViewHolder(binding.root)