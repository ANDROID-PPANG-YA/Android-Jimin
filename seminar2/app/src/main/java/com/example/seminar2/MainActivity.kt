package com.example.seminar2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seminar2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var position = FIRST_POSITION
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTransactionEvent()
    }

    private fun initTransactionEvent(){
        val fragment1 = Fragment1()
        val fragment2 = Fragment2()

        supportFragmentManager.beginTransaction().add(R.id.fragment_main, fragment1).commit()

        binding.btnFragment.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position){
                FIRST_POSITION -> {
                    transaction.replace(R.id.fragment_main, fragment2)
                    position = SECOND_POSITION
                }
                SECOND_POSITION -> {
                    transaction.replace(R.id.fragment_main, fragment1)
                    position = FIRST_POSITION
                }
            }
            transaction.commit()
        }
    }
    companion object{
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2
    }
}