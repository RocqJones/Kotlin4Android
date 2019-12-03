package com.rocqjones.intoverflown.dessertpusher

import android.app.Application
import timber.log.Timber

class PusherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // This api uses a lot of trees
        Timber.plant(Timber.DebugTree())
    }
}
