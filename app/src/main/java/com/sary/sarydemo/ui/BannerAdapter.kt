package com.sary.sarydemo.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sary.sarydemo.R
import com.sary.sarydemo.connections.model.CatalogResponse
import com.sary.sarydemo.connections.model.DataEntity
import com.sary.sarydemo.connections.model.Result
import com.sary.sarydemo.databinding.ItemAppDataBinding
import com.sary.sarydemo.databinding.ItemBannerBinding
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get

class BannerAdapter : RecyclerView.Adapter<BannerAdapter.BannerHolder> {
    var context: Context
    var cataloges: List<String>

    constructor(context: Context, cataloges: List<String>) {
        this.context = context
        this.cataloges = cataloges
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemBannerBinding.inflate(layoutInflater, parent, false)
        return BannerHolder(binding)
    }

    override fun getItemCount(): Int {
        return cataloges.size
    }

    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        Log.e("item", ".." + cataloges.get(position))

        if (!cataloges.get(position).isEmpty()) {
            val picasso = Picasso.with(context)
            picasso.load(cataloges.get(position))
                .into(holder.binding.ivImage)

        }
    }

    class BannerHolder(binding: ItemBannerBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ItemBannerBinding

        init {
            this.binding = binding
        }


        companion object {

        }
    }
}