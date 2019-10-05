package dev.daeyeon.remote.response


import com.google.gson.annotations.SerializedName

data class TrendingDeveloperResponse(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("repo")
    val repo: Repo,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("username")
    val username: String
) {
    data class Repo(
        @SerializedName("description")
        val description: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
    )
}