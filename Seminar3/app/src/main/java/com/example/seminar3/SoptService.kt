package com.example.seminar3

import com.example.seminar3.DataClass.RequestSignIn
import com.example.seminar3.DataClass.ResponseSignIn
import com.example.seminar3.DataClass.ResponseSignUp
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
        @Body body: ResponseSignUp
    ): Call<ResponseSignUp>
}