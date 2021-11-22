package com.example.roomhomeworkdefaultrepo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomhomeworkdefaultrepo.db.PostData


class TextAdapter(val data : ArrayList<PostData>) : RecyclerView.Adapter<TextAdapter.TextViewHolder>() {
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : TextViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        view.setOnClickListener {

        }
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.title.text = data.get(position).title
        holder.content.text = data.get(position).content
    }

    override fun getItemCount(): Int = data.size

    class TextViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.titleEditText)
        val content = view.findViewById<TextView>(R.id.contentEditText)
    }
}