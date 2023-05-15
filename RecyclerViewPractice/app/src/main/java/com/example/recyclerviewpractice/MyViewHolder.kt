package com.example.recyclerviewpractice

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val usernameTextView = itemView.findViewById<TextView>(R.id.user_name_txt)
    private val profileImageView = itemView.findViewById<ImageView>(R.id.img_profile)

    init {

    }

    fun bind(myModel: MyModel) {
        usernameTextView.text = myModel.name

    }
}