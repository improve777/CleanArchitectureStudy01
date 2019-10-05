package dev.daeyeon.remote.response


import com.google.gson.annotations.SerializedName

data class LanguageResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("urlParam")
    val urlParam: String
)