package com.example.seminar3.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.seminar3.SeminarSharedPreferences
import com.example.seminar3.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        isAutoLogout()
        setContentView(binding.root)

    }

    private fun isAutoLogout() {
        binding.btnAutoOff.setOnClickListener {
            SeminarSharedPreferences.setLogout(this)
            Toast.makeText(this@SettingsActivity, "자동로그인이 해제되었습니다.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@SettingsActivity, SignInActivity::class.java))
            finish()
        }
    }
}