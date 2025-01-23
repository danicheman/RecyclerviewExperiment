package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.databinding.DecorationViewBinding

import com.example.myapplication.placeholder.PlaceholderContent.PlaceholderItem
import com.example.myapplication.databinding.FragmentItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 2) {
            return ImageViewHolder(DecorationViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
        }
        return CustomViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemViewType(position: Int): Int {
        if (position == 5) {
            return 2
        }
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 5) {
            (holder as? ImageViewHolder)?.apply {

            }
        } else {
            (holder as? CustomViewHolder)?.apply {
                val item = values[position]
                holder.idView.text = item.id
                holder.contentView.text = item.content
            }
        }

    }

    override fun getItemCount(): Int = values.size

    inner class CustomViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
    inner class ImageViewHolder(binding: DecorationViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val decoration = binding.decoration
    }

}