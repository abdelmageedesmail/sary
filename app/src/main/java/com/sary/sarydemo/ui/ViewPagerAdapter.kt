package com.sary.sarydemo.ui

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.sary.sarydemo.R
import com.sary.sarydemo.connections.model.BannerResponse
import com.sary.sarydemo.connections.model.ResultEntity
import com.squareup.picasso.Picasso

class ViewPagerAdapter(internal var context: Context, internal var itemList: List<ResultEntity>) :
    PagerAdapter() {

    internal var mLayoutInflater: LayoutInflater
    private var pos = 0

    init {
        mLayoutInflater =
            this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return Integer.MAX_VALUE
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val holder = ViewHolder()
        val itemView = mLayoutInflater.inflate(R.layout.layout_item_view_pager, container, false)
        holder.itemImage = itemView.findViewById(R.id.img_slider) as ImageView

        if (pos > this.itemList.size - 1)
            pos = 0

        holder.sliderItem = this.itemList[pos]
//        holder.itemImage.setImageDrawable(context.getDrawable(holder.sliderItem.image))
        Log.e("imagess", "" + holder.sliderItem.image)
        Picasso.with(context).load(holder.sliderItem.image).into(holder.itemImage)
        (container as ViewPager).addView(itemView)

        holder.itemImage.scaleType = ImageView.ScaleType.FIT_XY

        holder.itemImage.setOnClickListener(View.OnClickListener { v ->
            Toast.makeText(context, holder.sliderItem.title, Toast.LENGTH_SHORT).show()
        })

        pos++
        return itemView
    }

    internal class ViewHolder {
        lateinit var sliderItem: ResultEntity
        lateinit var itemImage: ImageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as CardView)
    }

    override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
        return arg0 === arg1 as View
    }

    override fun destroyItem(arg0: View, arg1: Int, arg2: Any) {
        (arg0 as ViewPager).removeView(arg2 as View)
    }

}