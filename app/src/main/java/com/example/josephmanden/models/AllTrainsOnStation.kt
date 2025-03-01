package com.example.josephmanden.models

data class AllTrainsOnStation(val responseCode: String, val status: String, val trains: List<Train>)
