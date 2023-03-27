package com.example.graduationproject.presentation.sections.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.graduationproject.model.Section

class SectionsAdapterDiffCallback : DiffUtil.ItemCallback<Section>() {

    override fun areItemsTheSame(oldItem: Section, newItem: Section): Boolean {
        return oldItem.section == newItem.section
    }

    override fun areContentsTheSame(oldItem: Section, newItem: Section): Boolean {
        return oldItem == newItem
    }

}