@file:Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused"
)

package com.codingwithze.latihannewsorg.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingwithze.latihannewsorg.databinding.ItemCategoryBinding
import com.codingwithze.latihannewsorg.model.CategoryData

@Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused"
)
class CategoryAdapter(var listCategory : List<CategoryData> ): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var onClick : ((CategoryData) -> Unit)? = null

    class ViewHolder(var binding : ItemCategoryBinding ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.categoryName.text = listCategory[position].name
        Glide.with(holder.itemView).load(listCategory[position].picture).into(holder.binding.categoryImage)
        holder.binding.itemCategory.setOnClickListener {
            onClick!!.invoke(listCategory[position])
        }
    }

    override fun getItemCount(): Int {
        return listCategory.size
    }
}