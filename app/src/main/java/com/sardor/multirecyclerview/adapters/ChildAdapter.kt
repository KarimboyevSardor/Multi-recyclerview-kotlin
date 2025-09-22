package com.sardor.multirecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sardor.multirecyclerview.databinding.ItemChildBinding
import com.sardor.multirecyclerview.models.ChildData

class ChildAdapter(private val onItemClick :(Int) -> Unit) : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    private var childList: MutableList<ChildData> = mutableListOf()

    fun onSumbit(childList: MutableList<ChildData>) {
        this.childList = childList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(
            ItemChildBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.onBind(childList[position])
    }

    override fun getItemCount() = childList.size

    inner class ChildViewHolder(private val binding: ItemChildBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(childData: ChildData) {
            binding.itemChildImage.setOnClickListener {
                onItemClick.invoke(childData.id)
            }
        }
    }

}