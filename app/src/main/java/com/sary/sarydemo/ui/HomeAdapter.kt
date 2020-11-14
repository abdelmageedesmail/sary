package com.sary.sarydemo.ui

import android.content.Context
import android.content.RestrictionEntry
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sary.sarydemo.R
import com.sary.sarydemo.connections.model.DataEntity
import com.sary.sarydemo.connections.model.Result
import com.sary.sarydemo.databinding.ItemAppDataBinding
import com.sary.sarydemo.databinding.ItemCatDataBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder> {

    var context: Context
    var results: List<Result>
    var listItems = ArrayList<String>()

    constructor(context: Context, cataloges: List<Result>) {
        this.context = context
        this.results = cataloges

    }

    class HomeHolder(binding: ItemCatDataBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ItemCatDataBinding

        init {
            this.binding = binding
        }


        companion object {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemCatDataBinding.inflate(layoutInflater, parent, false)
        return HomeHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.binding.tvTitle.setText(results.get(position).title)
        Log.e("banner", "" + results.get(2).dataEntity.size)

        if (results.get(position).title.isEmpty()) {
            holder.binding.frBackGround.setBackgroundColor(Color.parseColor("#E0E0E0"))
            holder.binding.rvData.adapter =
                CatalogAdapter(context, results.get(position).dataEntity)
            holder.binding.rvData.layoutManager =
                GridLayoutManager(context, results.get(position).rowCount)
        }
        if (results.get(position).title.equals("الأقسام") || results.get(position).title.equals("By Category")) {
            holder.binding.frBackGround.setBackgroundColor(Color.WHITE)
            holder.binding.rvData.adapter =
                CategoriesAdapter(context, results.get(position).dataEntity)
            holder.binding.rvData.layoutManager =
                GridLayoutManager(context, results.get(position).rowCount)
        }
        if (results.get(position).dataType.equals("banner")) {
            holder.binding.frBackGround.setBackgroundColor(Color.WHITE)
            listItems.add(
                "https://devcdn.sary.co/Back_to_school_Group_Offer_Banners-AR_KAlq9Ll.png"
            )
            listItems.add(
                "https://devcdn.sary.co/Smashing_Offers_Group_Offer_Banners-01.png"
            )

            holder.binding.rvData.adapter =
                BannerAdapter(context, listItems)
            holder.binding.rvData.layoutManager =
                GridLayoutManager(context, 2)

        }
        if (results.get(position).title.equals("جهز منشأتك") || results.get(position).title.equals("By Business Type")) {
            holder.binding.frBackGround.setBackgroundColor(Color.WHITE)
            holder.binding.rvData.adapter =
                CategoriesAdapter(context, results.get(position).dataEntity)
            holder.binding.rvData.layoutManager =
                GridLayoutManager(context, results.get(position).rowCount)
        }

    }

    override fun getItemCount(): Int {
        return results.size
    }
}