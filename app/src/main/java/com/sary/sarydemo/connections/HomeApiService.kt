package com.sary.sarydemo.connections

import com.sary.sarydemo.connections.model.BannerResponse
import com.sary.sarydemo.connections.model.CatalogResponse
import com.sary.sarydemo.connections.model.Result
import com.sary.sarydemo.connections.model.ResultEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HomeApiService {

    @GET("baskets/76097/catalog/")
    fun getCataloges(
        @Header("Authorization") authorization: String,
        @Header("Device-Type") device: String,
        @Header("App-Version") version: String,
        @Header("Accept-Language") lang: String
    ): Call<CatalogResponse>

    @GET("v2.5.1/baskets/76097/banners/")
    fun getBanners(
        @Header("Authorization") authorization: String,
        @Header("Device-Type") device: String,
        @Header("App-Version") version: String,
        @Header("Accept-Language") lang: String
    ): Call<BannerResponse>
}