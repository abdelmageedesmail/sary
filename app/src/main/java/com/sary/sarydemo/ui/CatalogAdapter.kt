package com.sary.sarydemo.ui

import android.content.Context
import android.util.AttributeSet
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
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get

class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.CatalogHolder> {
    var context: Context
    var cataloges: List<DataEntity>

    constructor(context: Context, cataloges: List<DataEntity>) {
        this.context = context
        this.cataloges = cataloges

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.item_app_data, parent, false)
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemAppDataBinding.inflate(layoutInflater, parent, false)
        return CatalogHolder(binding)
    }

    override fun getItemCount(): Int {
        return cataloges.size
    }

    override fun onBindViewHolder(holder: CatalogHolder, position: Int) {
        if (!cataloges.get(position).image.isEmpty()) {
            val picasso = Picasso.with(context)
            picasso.load(cataloges.get(position).image)
                .into(holder.binding.ivImage)
        }
        holder.binding.tvName.setText(cataloges.get(position).name)
    }

    class CatalogHolder(binding: ItemAppDataBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ItemAppDataBinding

        init {
            this.binding = binding
        }


        companion object {

        }
    }
}