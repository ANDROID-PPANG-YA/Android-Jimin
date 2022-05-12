package com.example.seminar3.DataClass

import com.google.gson.annotations.SerializedName

data class RequestSignIn (
    @SerializedName("email")
    val id: String,
    val password: String
    )