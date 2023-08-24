package com.mwangi.contactlist.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mwangi.contactlist.databinding.ContactsListItemBinding
import com.mwangi.contactlist.model.ContactsData
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactsRvAdapter(var contactList:List<ContactsData>, val context: Context):RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding = ContactsListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var contact = contactList[position]
        var binding = holder.binding
        holder.binding.tvName.text = contact.name

        if (contact.avatar.isNotBlank()) {
            Picasso
                .get()
                .load(Uri.parse(contact.avatar))
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .into(holder.binding.ivAvatar)
        }

        binding.cvContact.setOnClickListener{
            val intent = Intent(context, ContactDetailsActivity::class.java)
            intent.putExtra("CONTACT_ID", contact.contactId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

class  ContactsViewHolder(var binding: ContactsListItemBinding): RecyclerView.ViewHolder(binding.root)