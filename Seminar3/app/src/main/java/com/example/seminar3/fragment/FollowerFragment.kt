package com.example.seminar3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar3.dataclass.FollowerData
import com.example.seminar3.adapter.FollowerAdapter
import com.example.seminar3.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {

    private lateinit var followerAdapter: FollowerAdapter
    private var _binding : FragmentFollowerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)

        initFollowerAdaptor()
        return binding.root
    }
        // Inflate the layout for this fragment
    private  fun initFollowerAdaptor(){
            followerAdapter = FollowerAdapter()
            binding.rvFollower.adapter= followerAdapter

            followerAdapter.followerList.addAll(
                listOf(
                    FollowerData("양지영", "7조"),
                    FollowerData("이혜빈", "7조"),
                    FollowerData("유지민", "7조"),
                    FollowerData("정지연", "7조"),
                    FollowerData("조재훈", "7조")
                )
            )
            followerAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}