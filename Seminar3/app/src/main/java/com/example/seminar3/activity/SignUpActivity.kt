package com.example.seminar3.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.seminar3.ServiceCreator
import com.example.seminar3.databinding.ActivitySignUpBinding
import com.example.seminar3.dataclass.RequestSignUp
import com.example.seminar3.enqueueUtil

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
            } else {
                startActivity(siIntent)
                finish()
            }
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

        val call = ServiceCreator.soptService.postSignUp(requestSignUp)

        call.enqueueUtil(
            onSuccess = {
                Toast.makeText(this@SignUpActivity, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show()
            },
            onError = {
                Toast.makeText(this@SignUpActivity, "회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show()
            }
        )

    }
}