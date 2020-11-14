package com.sary.sarydemo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.sary.sarydemo.R
import com.sary.sarydemo.connections.model.DataEntity
import com.sary.sarydemo.databinding.ActivityMainBinding
import com.sary.sarydemo.viewModel.HomeViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var model: HomeViewModel
    lateinit var binding: ActivityMainBinding
    var listItems = ArrayList<DataEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        model = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val doubleBounce: Sprite = DoubleBounce()
        binding.spinKit.setIndeterminateDrawable(doubleBounce)
        binding.spinKit.visibility = View.VISIBLE
        getBanners()
        getCatalog()

    }

    private fun getCatalog() {
        model.getData().observe(this, Observer { catagoles ->
            binding.spinKit.visibility = View.GONE
            binding.tvAccountStatus.setText(catagoles.other.businessStatus.title)
            binding.rvData.adapter = HomeAdapter(this, catagoles.resultEntity)
            binding.rvData.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.cardSpecialOrder.visibility = View.VISIBLE
        })
    }

    private fun getBanners() {
        model.getBanners().observe(this, Observer { banners ->
            var adapter = ViewPagerAdapter(this, banners.resultEntity)
            binding.viewPager.adapter = adapter
//            binding.dotsIndicator.setViewPager(binding.viewPager)
        })

    }
}