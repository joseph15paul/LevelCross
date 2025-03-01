package com.example.josephmanden.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.josephmanden.R
import com.example.josephmanden.models.AllTrainsOnStation
import com.example.josephmanden.network.AllTrainsOnStationService
import com.example.josephmanden.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.time.LocalTime
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {

    @Inject
    lateinit var allTrainsOnStationService: AllTrainsOnStationService

    private lateinit var allTrainsOnAngamalyDeferred: Deferred<AllTrainsOnStation>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        collectData()
        CoroutineScope(Dispatchers.IO).launch {
            if (isOpen())
                ""
                //TODO update UI
        }
        val moreButton = findViewById<Button>(R.id.more_button)
        moreButton.setOnClickListener {
            val intent = Intent(
                this@MainActivity2,
                MainActivity3::class.java
            )
            startActivity(intent)
        }
    }

    private fun collectData(){
        allTrainsOnAngamalyDeferred = CoroutineScope(Dispatchers.IO).async {
            return@async getAllTrainsOnAngamaly()
        }
    }

    private suspend fun getAllTrainsOnAngamaly(): AllTrainsOnStation {
        return allTrainsOnStationService.getAllTrainsOnStation(
            Constants.JOSEPHS_API_KEY,
            Constants.ANGAMALY_STATION_CODE
        )
    }

    private suspend fun isOpen(): Boolean {
        val allTrainsOnAngamaly = allTrainsOnAngamalyDeferred.await()
        val trainsList = allTrainsOnAngamaly.trains
        val currentTime =  LocalTime.now()
        trainsList.forEach{ train ->
            if (train.arrivalTime < currentTime && currentTime < train.departureTime)
                return false
        }
        return true
    }
}
