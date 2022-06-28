package com.example.seminar3.dataclass

data class ResponseSignUp(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: Int
    )
}