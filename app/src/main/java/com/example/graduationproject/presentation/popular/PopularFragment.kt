package com.example.graduationproject.presentation.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentPopularBinding
import com.example.graduationproject.databinding.FragmentSectionsBinding
import com.example.graduationproject.presentation.popular.adapter.PopularAdapter
import com.example.graduationproject.presentation.sections.SectionsAdapter
import com.example.graduationproject.presentation.sections.SectionsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularFragment : Fragment(R.layout.fragment_popular) {

    private val viewModel: PopularViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPopularBinding.bind(view)

        val adapter = PopularAdapter()
        binding.rvMostPopularNews.adapter = adapter
        binding.rvMostPopularNews.layoutManager = LinearLayoutManager(requireContext())
        viewModel.items.observe(viewLifecycleOwner) { adapter.differ.submitList(it) }

        binding.swipeRefresh.setOnRefreshListener { viewModel.update() }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it

        }

    }
}