package com.example.josephmanden.network

import com.example.josephmanden.models.AllTrainsOnStation
import retrofit2.http.GET
import retrofit2.http.Path

interface AllTrainsOnStationService {

    /*{
    "ResponseCode": "200",
    "Status": "SUCCESS",
    "Trains": [
        {
            "TrainNo": "16127",
            "TrainName": "MS GURUVAYUR",
            "Source": "MS",
            "ArrivalTime": "04:12:00",
            "Destination": "GUV",
            "DepartureTime": "04:13:00"
        },
        {
            "TrainNo": "16128",
            "TrainName": "GUV CHENNAI",
            "Source": "GUV",
            "ArrivalTime": "22:38:00",
            "Destination": "MS",
            "DepartureTime": "22:39:00"
        }
      ]
     }*/
    @GET("api/v2/AllTrainOnStation/apikey/{apiKey}/StationCode/{stationCode}/")
    suspend fun getAllTrainsOnStation(
        @Path("apiKey") apiKey: String,
        @Path("stationCode") stationCode: String,
    ): AllTrainsOnStation

}