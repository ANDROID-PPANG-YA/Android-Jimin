package com.example.seminar3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.seminar3.R
import com.example.seminar3.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding ?: error("Binding이 초기화되지 않았습니다.")
    private lateinit var sampleTabViewPagerAdapter: SampleTabViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(layoutInflater, container, false)

        initAdapter()
        initTabLayout()

        return binding.root
    }

    private fun initAdapter() {
        sampleTabViewPagerAdapter = SampleTabViewPagerAdapter(this)

        binding.vpSample.adapter = sampleTabViewPagerAdapter
    }

    private fun initTabLayout() {
        val tabLabel = listOf("첫 번째", "두 번째")

        TabLayoutMediator(binding.)
    }
}