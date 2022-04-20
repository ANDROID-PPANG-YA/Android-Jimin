package com.example.seminar1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.seminar1.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val suIntent = Intent(this, SignUpActivity::class.java)
        val homeIntent = Intent(this, HomeActivity::class.java)

        val etId = binding.editId.text
        val etPw = binding.editPw.text

        binding.buttonSi.setOnClickListener {
            if (etId.isEmpty() || etPw.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                startActivity(homeIntent)
            }
        }

        binding.buttonSu.setOnClickListener{
            startActivity(suIntent)
        }
    }
}