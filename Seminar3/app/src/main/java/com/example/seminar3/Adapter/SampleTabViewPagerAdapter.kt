package com.example.seminar3.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.seminar3.Fragment.TabFragment2
import com.example.seminar3.Fragment.TapFragment1

class SampleTabViewPagerAdapter(fragment: Fragment):
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> TapFragment1()
        1 -> TabFragment2()
        else -> throw Exception()
    }
    }