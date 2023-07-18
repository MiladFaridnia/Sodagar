package com.faridnia.sodagar

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SodagarApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}