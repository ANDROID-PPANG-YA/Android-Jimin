package com.example.seminar3

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SampleTabViewPagerAdapter(fragment: Fragment):
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> TabFragment1()
        1 -> TabFragment2()
        else -> throw Exception()
    }
    }