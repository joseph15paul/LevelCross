package com.example.josephmanden.models

import com.example.josephmanden.jsonAdapters.LocalTimeAdapter
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.time.LocalTime

data class Train(
    @SerializedName("TrainNo")
    val number: String,

    @SerializedName("TrainName")
    val name: String,

    @SerializedName("Source")
    val source: String,

    @SerializedName("ArrivalTime")
    @JsonAdapter(LocalTimeAdapter::class)
    val arrivalTime: LocalTime,

    @SerializedName("Destination")
    val destination: String,

    @SerializedName("DepartureTime")
    @JsonAdapter(LocalTimeAdapter::class)
    val departureTime: LocalTime
)
