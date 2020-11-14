package com.sary.sarydemo.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sary.sarydemo.connections.model.CatalogResponse
import com.sary.sarydemo.connections.ApiClient
import com.sary.sarydemo.connections.model.BannerResponse
import com.sary.sarydemo.connections.model.ResultEntity
import com.sary.sarydemo.utils.UtilsClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val token =
        "token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ODg2NiwidXNlcl9waG9uZSI6Ijk2NjU2NDk4OTI1MCJ9.VYE28vtnMRLmwBISgvvnhOmPuGueW49ogOhXm5ZqsGU"

    val cataloges: MutableLiveData<CatalogResponse> by lazy {
        MutableLiveData<CatalogResponse>()
    }
    val bannerSlider: MutableLiveData<BannerResponse> by lazy {
        MutableLiveData<BannerResponse>()
    }

    fun getData(): MutableLiveData<CatalogResponse> {
        val call: Call<CatalogResponse> =
            ApiClient.getClient.getCataloges(token, "android", "3.1.1.0.0", UtilsClass().getLang())

        call.enqueue(object : Callback<CatalogResponse> {
            override fun onResponse(
                call: Call<CatalogResponse>,
                response: Response<CatalogResponse>
            ) {
                if (response.isSuccessful()) {
                    Log.e("response", "" + response.body())
                    cataloges.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<CatalogResponse>, t: Throwable) {
                Log.e("error", call.toString())
            }
        })
        return cataloges
    }

    fun getBanners(): MutableLiveData<BannerResponse> {
        val call: Call<BannerResponse> =
            ApiClient.getClient.getBanners(
                token,
                "android",
                "3.1.1.0.0",
                UtilsClass().getLang()
            )
        call.enqueue(object : Callback<BannerResponse> {
            override fun onResponse(
                call: Call<BannerResponse>,
                response: Response<BannerResponse>
            ) {
                if (response.isSuccessful()) {
                    Log.e("response", "" + response.body())
                    bannerSlider.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<BannerResponse>, t: Throwable) {
//                weatherData!!.text = t.message
                Log.e("error", call.toString())
            }
        })
        return bannerSlider
    }
}