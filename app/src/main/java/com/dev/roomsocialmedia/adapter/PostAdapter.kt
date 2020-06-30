package com.dev.roomsocialmedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.roomsocialmedia.databinding.ListPostBinding
import com.dev.roomsocialmedia.db.model.Post

class PostAdapter(private val todoitems: List<Post>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListPostBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = todoitems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(todoitems[position])

    inner class ViewHolder(val binding: ListPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            binding.postlistt = item
            binding.executePendingBindings()

        }
    }
}