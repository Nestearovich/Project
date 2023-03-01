package com.example.graduationproject.presentation.sections

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentSectionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SectionsFragment : Fragment(R.layout.fragment_sections) {

    private val viewModel: SectionsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSectionsBinding.bind(view)

        val adapter = SectionsAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.items.observe(viewLifecycleOwner) { adapter.submitList(it) }


        binding.swipeRefresh.setOnRefreshListener { viewModel.update() }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it
        }
    }

}