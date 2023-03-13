package com.example.graduationproject.presentation.sections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationproject.databinding.ItemSectionBinding
import com.example.graduationproject.model.Section
import com.example.graduationproject.presentation.listener.NewsListener

class SectionsAdapter(
    private val newsListener: NewsListener
) :
    ListAdapter<Section, SectionsAdapter.ViewHolder>(SectionsAdapterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSectionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding,newsListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.textView.text = item.section
        holder.bind(item)
    }


    class ViewHolder(val binding: ItemSectionBinding,private val newsListener: NewsListener) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(sectionsEntity: Section){
            itemView.setOnClickListener {
                newsListener.onElementSelected(
                    sectionsEntity.section,
                    sectionsEntity.displayName
                )
            }
        }
    }

}