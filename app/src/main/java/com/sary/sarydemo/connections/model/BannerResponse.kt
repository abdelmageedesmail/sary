package com.sary.sarydemo.connections.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BannerResponse(

    @Expose
    @SerializedName("result")
    val resultEntity: List<ResultEntity>,
    @Expose
    @SerializedName("status")
    val status: Boolean
)

data class ResultEntity(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("button_text")
    val buttonText: String,
    @Expose
    @SerializedName("expiry_status")
    val expiryStatus: Boolean,
    @Expose
    @SerializedName("created_at")
    val createdAt: String,
    @Expose
    @SerializedName("start_date")
    val startDate: String,
    @Expose
    @SerializedName("expiry_date")
    val expiryDate: String,
    @Expose
    @SerializedName("image")
    val image: String,
    @Expose
    @SerializedName("priority")
    val priority: Int,
    @Expose
    @SerializedName("photo")
    val photo: String,
    @Expose
    @SerializedName("link")
    val link: String,
    @Expose
    @SerializedName("level")
    val level: String,
    @Expose
    @SerializedName("is_available")
    val isAvailable: Boolean,
    @Expose
    @SerializedName("branch")
    val branch: Int
)