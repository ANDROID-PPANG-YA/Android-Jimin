package com.example.seminar3.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.seminar3.ServiceCreator
import com.example.seminar3.databinding.ActivitySignUpBinding
import com.example.seminar3.dataclass.RequestSignUp
import com.example.seminar3.dataclass.ResponseSignUp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val siIntent = Intent(this, SignInActivity::class.java)

        val eName = binding.EditName.text
        val eId = binding.EditId.text
        val ePw = binding.EditPw.text

        binding.buttonSuCom.setOnClickListener {
            if (eName.isEmpty() || eId.isEmpty() || ePw.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }else{
                startActivity(siIntent)
                finish()}
        }
        initEvent()
    }

    private fun initEvent() {
        binding.buttonSuCom.setOnClickListener {
            signupNetwork()
        }
    }

    private fun signupNetwork() {
        val requestSignUp = RequestSignUp(
            name = binding.EditName.text.toString(),
            id = binding.EditId.text.toString(),
            password = binding.EditPw.text.toString()
        )

        val call: Call<ResponseSignUp> = ServiceCreator.soptService.postSignUp(requestSignUp)

        call.enqueue(object : Callback<ResponseSignUp> {
            override fun onResponse(
                call: Call<ResponseSignUp>,
                response: Response<ResponseSignUp>
            ) {
                if(response.isSuccessful) {

                    Toast.makeText(
                        this@SignUpActivity,
                        "회원가입 성공!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                } else Toast.makeText(this@SignUpActivity, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        }

        )


    }
}