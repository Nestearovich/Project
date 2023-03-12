package com.example.graduationproject.presentation.listener

import com.example.graduationproject.model.Article

interface Listener {
    fun onClick(article: Article)
}