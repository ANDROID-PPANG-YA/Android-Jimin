package com.example.seminar3.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.seminar3.R
import com.example.seminar3.databinding.ActivityHomeBinding
import com.example.seminar3.fragment.FollowerFragment
import com.example.seminar3.fragment.RepositoryFragment

class HomeActivity : AppCompatActivity() {
    private var position = FIRST_POSITION
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initTransactionEvent()
        initSettingClickEvent()
    }


    private fun initTransactionEvent() {
        val fragment1 = FollowerFragment()
        val fragment2 = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragment_home, fragment1).commit()

        binding.btnFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position) {
                FIRST_POSITION -> {
                    transaction.replace(R.id.fragment_home, fragment1)
                    position = SECOND_POSITION
                }
            }
            transaction.commit()
        }

        binding.btnRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position) {
                SECOND_POSITION -> {
                    transaction.replace(R.id.fragment_home, fragment2)
                    position = FIRST_POSITION
                }
            }
            transaction.commit()
        }

    }

    private fun initSettingClickEvent() {
        val Intent = Intent(this, SettingsActivity::class.java)
        binding.ivSetting.setOnClickListener {
            startActivity(Intent)
        }
    }

    companion object {
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2
    }

}