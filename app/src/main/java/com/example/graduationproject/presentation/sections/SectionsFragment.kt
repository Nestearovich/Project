package com.example.graduationproject.presentation.sections

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentSectionsBinding
import com.example.graduationproject.presentation.article.ArticleFragment
import com.example.graduationproject.presentation.listener.NewsListener
import com.example.graduationproject.presentation.sections.adapter.SectionsAdapter
import com.example.graduationproject.utils.NavigateHalper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SectionsFragment : Fragment(R.layout.fragment_sections), NewsListener {

    private val viewModel: SectionsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSectionsBinding.bind(view)

        val adapter = SectionsAdapter(this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.items.observe(viewLifecycleOwner) { adapter.submitList(it) }




    }

    override fun onElementSelected(section: String?, displayName: String?) {
        navigateWithBundle(
            R.id.action_sectionsFragment_to_articleFragment,
            ArticleFragment.createArgument(section, displayName)
        )
    }

}