package com.sardor.multirecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sardor.multirecyclerview.databinding.ItemPranetBinding
import com.sardor.multirecyclerview.models.ParentData

class ParentAdapter(private val onItemClick :(Int) -> Unit) : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    private var parentList: MutableList<ParentData> = mutableListOf()

    fun onSubmit(parentList: MutableList<ParentData>) {
        this.parentList = parentList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(
            ItemPranetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        holder.onBind(parentList[position])
    }

    override fun getItemCount() = parentList.size

    inner class ParentViewHolder(private val binding: ItemPranetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(parentData: ParentData) {
            val childAdapter = ChildAdapter(onItemClick = {
                onItemClick.invoke(it)
            })
            binding.apply {
                itemParentTv.text = parentData.name
                val total = parentData.childData.size
                childAdapter.onSumbit(parentData.childData)

                val layoutManager = GridLayoutManager(
                    binding.root.context,
                    6,
                    RecyclerView.VERTICAL,
                    false
                )

                layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when {
                            total == 8 -> {
                                if (position < 2) 3
                                else 2
                            }
                            total % 3 == 0 -> 2
                            total % 2 == 0 -> 3
                            total % 3 == 2 -> {
                                if (position < 3) 2 else 3
                            }
                            total % 2 == 1 -> {
                                if (position == 0) 6
                                else 2
                            }
                            else -> 2
                        }
                    }
                }

                itemChildRv.layoutManager = layoutManager
                itemChildRv.adapter = childAdapter
            }
        }
    }
}