package com.rocqjones.intoverflown.devbyteviewer

import android.app.Application
import android.os.Build
import androidx.work.*
import com.rocqjones.intoverflown.devbyteviewer.work.RefreshDataWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Override application to setup background work via WorkManager
 */
class DevByteApplication : Application() {
    /**
     * Add a coroutine scope variable, applicationScope, which uses Dispatchers.Default:
     */
    val applicationScope = CoroutineScope(Dispatchers.Default)

    /**
     * Create an initialization function that does not block the main thread:
     * It's important to note that WorkManager.initialize should be called from inside onCreate without using a background thread to
     * avoid issues caused when initialization happens after WorkManager is used.
     *
     * delayedInit() uses the applicationScope you defined above. It should call a function (which you haven't created yet) called
     * setupRecurringWork().
     */
    private fun delayedInit() {
        applicationScope.launch {
            setupRecurringWork()
        }
    }

    /**
     * setupRecurringWork() function. In it, define a repeatingRequest variable that uses a PeriodicWorkRequestBuilder to create a
     * PeriodicWorkRequest for your RefreshDataWorker. It should run once every day.
     */
    private fun setupRecurringWork() {
        // Define constraints to prevent work from occurring when there is no network access or the device is low on battery.
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresBatteryNotLow(true)
            .setRequiresCharging(true)
            .apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setRequiresDeviceIdle(true)
                }
            }.build()

        /**
         * add the constraint to the repeatingRequest definition.
         */
        val repeatingRequest
                = PeriodicWorkRequestBuilder<RefreshDataWorker>(1, TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()

        /**
         * Schedule the work as unique:
         * Get an instance of WorkManager and call enqueueUniquePeriodicWork to schedule the work.
         *
         * Ceate a unique identifier for your work:
         * In RefreshDataWorker.kt, create a companion object and define a work name that can be used to uniquely identify this worker.
         */
        WorkManager.getInstance().enqueueUniquePeriodicWork(
            RefreshDataWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest)
    }

    /**
     * onCreate is called before the first screen is shown to the user.
     *
     * Use it to setup any background tasks, running expensive setup operations in a background
     * thread to avoid delaying app start.
     */
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        /**
         * Add a call to delayedInit() in onCreate().
         */
        delayedInit()
    }
}
