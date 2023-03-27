package com.example.graduationproject.presentation.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.databinding.FragmentFavoriteBinding
import com.example.graduationproject.presentation.favorite.adapter.FavoriteAdapter
import com.example.graduationproject.presentation.listener.FavoriteListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment(),FavoriteListener {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val viewModel : FavoriteViewModel by viewModels()

    private lateinit var favAdapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favAdapter = FavoriteAdapter(this)
        val recyclerView = binding.favRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = favAdapter

        viewModel.getFavorites()


        viewModel.favorites.observe(viewLifecycleOwner){
            favAdapter.submitList(it)
        }
    }

    override fun onDeleteClicked(id: Long) {
        viewModel.deleteFavorite(id)
    }

}