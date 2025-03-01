package com.example.josephmanden.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.josephmanden.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button by its ID and set OnClickListener for current_Status_button
        val currentStatusButton = findViewById<Button>(R.id.current_Status_button)
        currentStatusButton.setOnClickListener {
            // Create an Intent to start MainActivity2
            val intent = Intent(
                this@MainActivity,
                MainActivity2::class.java
            )
            startActivity(intent) // Start MainActivity2
        }

        // Find the button by its ID and set OnClickListener for train_schedule_button
        val trainScheduleButton = findViewById<Button>(R.id.train_schedule_button)
        trainScheduleButton.setOnClickListener {
            // Create an Intent to start MainActivity3
            val intent = Intent(
                this@MainActivity,
                MainActivity3::class.java
            )
            startActivity(intent) // Start MainActivity3
        }
    }
}

