package com.example.recylerexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SimpleRecycleViewAdapter : ListAdapter<SomeTextItem, SimpleRecycleViewAdapter.SimpleViewHolder>(SimpleDiffCallback) {

    class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: EditText = itemView.findViewById(R.id.numberedit)

        fun bind(itemView: SomeTextItem) {
            textView.setText(itemView.text)
            textView.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_edit, parent, false)
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        val textItem = getItem(position)
        holder.bind(textItem)
    }
}

object SimpleDiffCallback : DiffUtil.ItemCallback<SomeTextItem>() {
    override fun areItemsTheSame(oldItem: SomeTextItem, newItem: SomeTextItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SomeTextItem, newItem: SomeTextItem): Boolean {
        return oldItem.id == newItem.id
    }
}