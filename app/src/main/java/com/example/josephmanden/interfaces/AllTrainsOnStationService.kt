package com.example.josephmanden.interfaces

import com.example.josephmanden.models.AllTrainsOnStation
import retrofit2.http.GET
import retrofit2.http.Path

interface AllTrainsOnStationService {

    @GET("api/v2/AllTrainOnStation/apikey/{apiKey}/StationCode/{stationCode}/")
    suspend fun getAllTrainsOnStation(
        @Path("apiKey") apiKey: String,
        @Path("stationCode") stationCode: String,
    ): AllTrainsOnStation

}