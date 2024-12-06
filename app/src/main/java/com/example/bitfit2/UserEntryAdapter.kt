package com.example.bitfit2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserEntryAdapter(private val entries: List<UserEntry>) :
    RecyclerView.Adapter<UserEntryAdapter.UserEntryViewHolder>() {

    class UserEntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heightTextView: TextView = itemView.findViewById(R.id.tvHeight)
        val weightTextView: TextView = itemView.findViewById(R.id.tvWeight)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserEntryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_entry, parent, false)
        return UserEntryViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserEntryViewHolder, position: Int) {
        val entry = entries[position]
        holder.heightTextView.text = "Height: ${entry.height}"
        holder.weightTextView.text = "Weight: ${entry.weight}"
    }

    override fun getItemCount() = entries.size
}
