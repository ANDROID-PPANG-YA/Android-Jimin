package com.example.seminar1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar1.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {
    private var binding : FragmentFollowerBinding? = null
    private val binding get() = binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_follower, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}