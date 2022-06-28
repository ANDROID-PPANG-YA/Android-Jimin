package com.example.seminar3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar3.adapter.SampleTabViewPagerAdapter
import com.example.seminar3.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화되지 않았습니다.")
    private lateinit var sampleTabViewPagerAdapter: SampleTabViewPagerAdapter

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

            initAdapter()
            initTabLayout()

            return binding.root
        }


        private fun initAdapter() {
            sampleTabViewPagerAdapter = SampleTabViewPagerAdapter(this)

            binding.vpFragmentHome.adapter = sampleTabViewPagerAdapter
        }

        private fun initTabLayout() {
            val tabLabel = listOf("팔로잉", "팔로워")

            TabLayoutMediator(binding.tlFragmentHome, binding.vpFragmentHome) { tab, position ->
                tab.text = tabLabel[position]
            }.attach()
        }
}