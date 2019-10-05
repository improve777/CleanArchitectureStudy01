package dev.daeyeon.githubsampleapp.model

data class TrendingRepoModel(
    val author: String,
    val avatar: String,
    val currentPeriodStars: Int,
    val description: String,
    val forks: Int,
    val language: String,
    val languageColor: String,
    val name: String,
    val stars: Int,
    val url: String
)