package com.example.seminar2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminar2.databinding.ItemSampleListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    private val userlist = mutableListOf<UserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            ItemSampleListBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position : Int){
        holder.onBind(userlist[position])
    }

    override fun getItemCount(): Int = userlist.size

    class FollowerViewHolder(
        private val binding: ItemSampleListBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: UserData) {
            binding.tvName.text = data.name
            binding.tvIntroduce.text = data.introduction
        }
    }
}