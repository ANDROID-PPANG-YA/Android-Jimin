package com.example.seminar1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar1.databinding.FragmentRepositoryBinding
import com.example.seminar2.RepositoryAdapter
import com.example.seminar2.RepositoryData

class RepositoryFragment : Fragment() {
    private lateinit var repositoryAdapter: RepositoryAdapter
    private var _binding : FragmentRepositoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        initAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(){
        repositoryAdapter = RepositoryAdapter()
        binding.rvRepository.adapter = repositoryAdapter

        repositoryAdapter.repositoryList.addAll(
            listOf(
                RepositoryData("안드 과제 레포","안드 파트 과제"),
                RepositoryData("안드 과제 레포","안드 파트 과제"),
                RepositoryData("안드 과제 레포","안드 파트 과제"),
                RepositoryData("안드 과제 레포","안드 파트 과제")
            )
        )
        repositoryAdapter.notifyDataSetChanged()
    }
}