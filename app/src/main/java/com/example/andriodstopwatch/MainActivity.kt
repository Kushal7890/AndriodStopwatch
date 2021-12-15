package com.example.andriodstopwatch

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var chronometer: Chronometer? = null
    private var pauseoffset: Long = 0
    private var running = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var chronometer: Chronometer? = null

        chronometer = findViewById(R.id.chronometer)
        chronometer.setFormat("Time: %s")
    }

    fun startChronometer(v: View?) {
        if (!running) {
            chronometer!!.base = SystemClock.elapsedRealtime() - pauseoffset
            chronometer!!.start()
            running = true
        }
    }

    fun pauseChronometer(v: View?) {
        if (running) {
            chronometer!!.stop()
            pauseoffset = SystemClock.elapsedRealtime() - chronometer!!.base
            running = false
        }
    }

    fun resetChronometer(v: View?) {
        chronometer!!.base = SystemClock.elapsedRealtime()
        pauseoffset = 0
    }
}