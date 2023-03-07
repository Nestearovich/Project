package com.example.graduationproject.presentation.sections

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentSectionsBinding
import com.example.graduationproject.presentation.listener.NewsListener
import com.example.graduationproject.utils.NavigateHalper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SectionsFragment : Fragment(R.layout.fragment_sections),NewsListener {

    private val viewModel: SectionsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSectionsBinding.bind(view)

        val adapter = SectionsAdapter(this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.items.observe(viewLifecycleOwner) { adapter.submitList(it) }


        binding.swipeRefresh.setOnRefreshListener { viewModel.update() }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it
        }


        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val bundle = Bundle()
                bundle.putString("section",navBundle.section)

                Toast.makeText(context, "called", Toast.LENGTH_SHORT).show()

                navigateWithBundle(
                    navBundle.destinationId,
                    bundle
                )
                viewModel.userNavigated()
            }
        }


    }

    override fun onClick() {
        TODO("Not yet implemented")
    }

    override fun onElementSelected(section: String?, displayName: String?) {
        viewModel.elementClicked(section,displayName)
    }
}