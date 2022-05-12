package com.example.seminar3.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.seminar3.Fragment.CameraFragment
import com.example.seminar3.Fragment.HomeFragment
import com.example.seminar3.Fragment.ProfileFragment

class TestViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> ProfileFragment()
        1 -> HomeFragment()
        2 -> CameraFragment()
        else -> throw Exception()
    }

}