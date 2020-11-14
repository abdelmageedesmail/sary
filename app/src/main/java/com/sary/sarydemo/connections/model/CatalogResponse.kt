package com.sary.sarydemo.connections.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CatalogResponse(

    @Expose
    @SerializedName("result")
    var resultEntity: List<Result>,
    @Expose
    @SerializedName("other")
    var other: OtherEntity,
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("status")
    var status: Boolean
)

data class OtherEntity(
    @Expose
    @SerializedName("show_special_order_view")
    var showSpecialOrderView: Boolean,
    @Expose
    @SerializedName("uncompleted_profile_settings")
    var uncompletedProfileSettings: UncompletedProfileSettingsEntity,
    @Expose
    @SerializedName("business_status")
    var businessStatus: BusinessStatusEntity
)

data class BusinessStatusEntity(
    @Expose
    @SerializedName("id")
    var id: Int,
    @Expose
    @SerializedName("title")
    val title: String
)

data class UncompletedProfileSettingsEntity(
    @Expose
    @SerializedName("show_tag")
    var showTag: Boolean,
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("image")
    val image: String,
    @Expose
    @SerializedName("is_completed_profile")
    var isCompletedProfile: Boolean
)

data class Result(
    @Expose
    @SerializedName("id")
    var id: Int,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("data")
    var dataEntity: List<DataEntity>,

//    @SerializedName("data")
//    var bannerEntity: BannerEntity,
    @Expose
    @SerializedName("data_type")
    val dataType: String,
    @Expose
    @SerializedName("show_title")
    var showTitle: Boolean,
    @Expose
    @SerializedName("ui_type")
    val uiType: String,
    @Expose
    @SerializedName("row_count")
    var rowCount: Int
)

data class DataEntity(
    @Expose
    @SerializedName("group_id")
    var groupId: Int,
    @Expose
    @SerializedName("filters")
    var filtersEntity: List<FiltersEntity>,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("image")
    val image: String,
    @Expose
    @SerializedName("empty_content_image")
    val emptyContentImage: String,
    @Expose
    @SerializedName("empty_content_message")
    val emptyContentMessage: String,
    @Expose
    @SerializedName("has_data")
    var hasData: Boolean,
    @Expose
    @SerializedName("priority")
    var priority: Int,
    @Expose
    @SerializedName("show_unavailable_items")
    var showUnavailableItems: Boolean,
    @Expose
    @SerializedName("show_in_brochure_link")
    var showInBrochureLink: Boolean,
//    @Expose
//    @SerializedName("image")
//    var imageBanner: String,
    @Expose
    @SerializedName("deep_link")
    var deep_link: String
)

data class FiltersEntity(
    @Expose
    @SerializedName("filter_id")
    var filterId: Int,
    @Expose
    @SerializedName("name")
    val name: String
)




