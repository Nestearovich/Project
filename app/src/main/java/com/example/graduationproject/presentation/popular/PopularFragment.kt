package com.example.graduationproject.presentation.popular

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentPopularBinding
import com.example.graduationproject.model.Popular
import com.example.graduationproject.presentation.listener.PopListener
import com.example.graduationproject.presentation.popular.adapter.PopularAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularFragment : Fragment(R.layout.fragment_popular),PopListener {

    private val viewModel: PopularViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPopularBinding.bind(view)

        val adapter = PopularAdapter(this)
        binding.rvMostPopularNews.adapter = adapter
        binding.rvMostPopularNews.layoutManager = LinearLayoutManager(requireContext())
        viewModel.items.observe(viewLifecycleOwner) { adapter.submitList(it) }

        binding.swipeRefresh.setOnRefreshListener { viewModel.update() }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it

        }

    }

    override fun onClick(popular: Popular) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(requireContext(), Uri.parse(popular.url))
    }
}