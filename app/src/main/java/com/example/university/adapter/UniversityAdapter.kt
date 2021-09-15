package com.example.university.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.university.ItemClickListener
import com.example.university.databinding.ItemUniBinding
import com.example.university.model.UniversityListItem


class UniversityAdapter(
    context: Context,
    uniResponseList: List<UniversityListItem>,
    clickListener: ItemClickListener
) : RecyclerView.Adapter<UniversityAdapter.MyViewHolder>() {
    private var uniResponseList: List<UniversityListItem>
    private lateinit var binding: ItemUniBinding
    private var context: Context
    private val clickListener:ItemClickListener


    fun setUniList(uniResponseList: List<UniversityListItem>) {
        this.uniResponseList = uniResponseList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemUniBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        uniResponseList[position].apply {
            binding.tvUniName.text = name
            binding.tvCountryTxt.text = alpha_two_code
            binding.itemViewUni.setOnClickListener {
                clickListener.onClick(web_pages[0])
            }
        }


    }

    override fun getItemCount(): Int {
        return uniResponseList.size
    }

    inner class MyViewHolder(itemBinding: ItemUniBinding) :
        RecyclerView.ViewHolder(itemBinding.root)


    init {
        this.uniResponseList = uniResponseList
        this.context = context
        this.clickListener=clickListener
    }
}
