package com.example.graduationproject.presentation.article

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentArticalBinding
import com.example.graduationproject.model.Article
import com.example.graduationproject.presentation.article.adapter.ArticleAdapter
import com.example.graduationproject.presentation.listener.Listener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleFragment : Fragment(R.layout.fragment_artical),Listener {

    private val viewModel: ArticleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentArticalBinding.bind(view)

        val adapter = ArticleAdapter(this)
        binding.recyclerArticle.adapter = adapter
        binding.recyclerArticle.layoutManager = LinearLayoutManager(requireContext())
        viewModel.items.observe(viewLifecycleOwner) { adapter.submitList(it) }

        binding.swipeRefresh.setOnRefreshListener { viewModel.update() }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it
        }



    }

    companion object {
        const val SECTION_KEY = "section_arg"
        const val DISPLAY_NAME_KEY = "display_name_arg"
        fun createArgument(section: String?, displayName: String?): Bundle {
            return bundleOf(
                SECTION_KEY to section,
                DISPLAY_NAME_KEY to displayName,
            )
        }
    }

    override fun onClick(article: Article) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(requireContext(), Uri.parse(article.url))
    }

    override fun onFavClicked(id: Long) {
        viewModel.onFavClicked(id)
    }


}