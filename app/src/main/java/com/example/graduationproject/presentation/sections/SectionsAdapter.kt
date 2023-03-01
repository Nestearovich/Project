package com.example.graduationproject.presentation.sections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationproject.databinding.ItemSectionBinding
import com.example.graduationproject.model.Section

class SectionsAdapter :
    ListAdapter<Section, SectionsAdapter.ViewHolder>(SectionsAdapterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSectionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.textView.text = item.section
    }

    class ViewHolder(val binding: ItemSectionBinding) : RecyclerView.ViewHolder(binding.root)

}