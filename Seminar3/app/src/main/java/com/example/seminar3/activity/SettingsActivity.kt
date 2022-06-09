package com.example.seminar3.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seminar3.R
import com.example.seminar3.databinding.ActivitySettingsBinding
import com.example.seminar3.databinding.ActivitySignInBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_settings)
    }
}