package com.example.seminar3.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.seminar3.DataClass.RequestSignIn
import com.example.seminar3.DataClass.ResponseSignIn
import com.example.seminar3.ServiceCreator
import com.example.seminar3.databinding.ActivitySignInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEvent()
    }

    private fun initEvent() {
        binding.buttonSi.setOnClickListener {
            loginNetwork()
        }
    }

    private fun loginNetwork() {
        val requestSignIn = RequestSignIn(
            id = binding.editId.text.toString(),
            password = binding.editPw.text.toString()
        )

        val call: Call<ResponseSignIn> = ServiceCreator.soptService.postLogin(requestSignIn)

        call.enqueue(object : Callback<ResponseSignIn> {
            override fun onResponse(
                call: Call<ResponseSignIn>,
                response: Response<ResponseSignIn>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(
                        this@SignInActivity,
                        "${data?.email}님 반갑습니다!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                } else Toast.makeText(this@SignInActivity, "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onFailure(call: Call<ResponseSignIn>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }
}