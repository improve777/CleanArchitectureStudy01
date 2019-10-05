package dev.daeyeon.domain.entity

data class TrendingRepo(
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