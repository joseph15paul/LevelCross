package com.example.josephmanden.models

import com.google.gson.annotations.SerializedName

data class AllTrainsOnStation(
    @SerializedName("ResponseCode")
    val responseCode: String,

    @SerializedName("Status")
    val status: String,

    @SerializedName("Trains")
    val trains: List<Train>)
