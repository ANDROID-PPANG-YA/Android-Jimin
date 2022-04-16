package com.example.seminar1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.seminar1.databinding.ActivitySignUpBinding

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
    }
}