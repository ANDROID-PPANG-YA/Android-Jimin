package com.example.seminar3.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.seminar3.SeminarSharedPreferences
import com.example.seminar3.ServiceCreator
import com.example.seminar3.databinding.ActivitySignInBinding
import com.example.seminar3.dataclass.RequestSignIn
import com.example.seminar3.dataclass.ResponseSignIn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        val suIntent = Intent(this, SignUpActivity::class.java)

        binding.buttonSu.setOnClickListener {
            startActivity(suIntent)
        }

        initEvent()
        initClickEvent()
        isAutoLogin()

        setContentView(binding.root)
    }

    private fun initEvent() {
        binding.buttonSi.setOnClickListener {
            loginNetwork()
        }
    }

    private fun initClickEvent() {
        binding.ibCheckbox.setOnClickListener {
            binding.ibCheckbox.isSelected = !binding.ibCheckbox.isSelected

            SeminarSharedPreferences.setAutoLogin(this, binding.ibCheckbox.isSelected)
        }
    }

    private fun isAutoLogin() {
        if (SeminarSharedPreferences.getAutoLogin(this)) {
            shortToast("자동로그인 되었습니다.")
            startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
            finish()
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