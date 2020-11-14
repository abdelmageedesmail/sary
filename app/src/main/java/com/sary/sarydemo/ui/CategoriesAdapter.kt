package com.sary.sarydemo.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sary.sarydemo.connections.model.DataEntity
import com.sary.sarydemo.connections.model.Result
import com.sary.sarydemo.databinding.ItemCatDataBinding
import com.sary.sarydemo.databinding.ItemCategoryBinding
import com.squareup.picasso.Picasso

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoryHolder> {


    var context: Context
    var results: List<DataEntity>

    constructor(context: Context, cataloges: List<DataEntity>) {
        this.context = context
        this.results = cataloges

    }

    class CategoryHolder(binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ItemCategoryBinding

        init {
            this.binding = binding
        }


        companion object {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemCategoryBinding.inflate(layoutInflater, parent, false)
        return CategoryHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        Picasso.with(context).load(results.get(position).image).into(holder.binding.ivCat)
    }

    override fun getItemCount(): Int {
        return results.size
    }

}