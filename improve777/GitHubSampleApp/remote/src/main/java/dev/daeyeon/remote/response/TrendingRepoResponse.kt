package dev.daeyeon.remote.response


import com.google.gson.annotations.SerializedName

data class TrendingRepoResponse(
    @SerializedName("author")
    val author: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("builtBy")
    val builtBy: List<BuiltBy>,
    @SerializedName("currentPeriodStars")
    val currentPeriodStars: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("language")
    val language: String,
    @SerializedName("languageColor")
    val languageColor: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("stars")
    val stars: Int,
    @SerializedName("url")
    val url: String
) {
    data class BuiltBy(
        @SerializedName("avatar")
        val avatar: String,
        @SerializedName("href")
        val href: String,
        @SerializedName("username")
        val username: String
    )
}