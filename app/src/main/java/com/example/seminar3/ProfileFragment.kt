package com.example.seminar3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.seminar1.RepositoryFragment
import com.example.seminar3.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화되지 않았습니다.")
    private lateinit var testViewPagerAdapter: TestViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater,container,false)

        binding.btnFollower.isSelected = true
        binding.btnRepository.isSelected = false
        initTransactionFragment()
        initImage()

        return binding.root
    }

    private fun initImage() {
        Glide.with(this)
            .load(R.drawable.photo)
            .circleCrop()
            .into(binding.ivPhoto)
    }

    private fun initTransactionFragment() {
        val fragment1 = FollowerFragment()
        val fragment2 = RepositoryFragment()

        childFragmentManager.beginTransaction().add(R.id.fragment_profile, fragment1).commit()

        binding.btnFollower.setOnClickListener {
            val transaction = childFragmentManager.beginTransaction()
            binding.btnFollower.isSelected = true
            binding.btnRepository.isSelected = false
            transaction.replace(R.id.fragment_profile, fragment1)
            transaction.commit()
        }

        binding.btnRepository.setOnClickListener {
            val transaction = childFragmentManager.beginTransaction()
            binding.btnRepository.isSelected = true
            binding.btnFollower.isSelected = false
            transaction.replace(R.id.fragment_profile, fragment2)
            transaction.commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }