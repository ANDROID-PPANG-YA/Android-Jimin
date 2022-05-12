package com.example.seminar3.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminar3.DataClass.RepositoryData
import com.example.seminar3.databinding.RepositoryListBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {
    val repositoryList = mutableListOf<RepositoryData>()

    class RepositoryViewHolder(
        private val binding: RepositoryListBinding
        ) : RecyclerView.ViewHolder(binding.root) {
            fun onBind(data: RepositoryData) {
                binding.tvReponame.text = data.reponame
                binding.tvRepocontent.text = data.repointro
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding =
            RepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }

    override fun getItemCount(): Int = repositoryList.size
    }