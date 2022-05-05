package com.example.seminar1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seminar1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private var position = FIRST_POSITION
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTransactionEvent()
    }


    private fun initTransactionEvent() {
        val fragment1 = FollowerFragment()
        val fragment2 = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragment_home, fragment1).commit()

        binding.btnFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when(position) {
                FIRST_POSITION -> {
                    transaction.replace(R.id.fragment_home, fragment1)
                    position = SECOND_POSITION
                }
            }
            transaction.commit()
            }

        binding.btnRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when(position) {
                SECOND_POSITION -> {
                    transaction.replace(R.id.fragment_home,fragment2)
                    position = FIRST_POSITION
                }
            }
            transaction.commit()
        }

            }

    companion object {
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2
    }

}