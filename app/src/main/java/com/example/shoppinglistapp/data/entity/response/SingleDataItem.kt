package com.example.shoppinglistapp.data.entity.response


import com.google.gson.annotations.SerializedName

data class SingleDataItem(
    @SerializedName("data")
    val data: Data = Data(),
    @SerializedName("status")
    val status: Int = 0
)