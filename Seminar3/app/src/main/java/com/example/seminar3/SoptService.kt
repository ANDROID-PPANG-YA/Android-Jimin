package com.example.seminar3

import com.example.seminar3.dataclass.RequestSignIn
import com.example.seminar3.dataclass.RequestSignUp
import com.example.seminar3.dataclass.ResponseSignIn
import com.example.seminar3.dataclass.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("auth/signin")
    fun postLogin(
        @Body body: RequestSignIn
    ): Call<ResponseSignIn>

    @POST("auth/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>
}