package com.rocqjones.intoverflown.devbyteviewer.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.rocqjones.intoverflown.devbyteviewer.database.getDatabase
import com.rocqjones.intoverflown.devbyteviewer.repository.VideosRepository
import retrofit2.HttpException

/**
 * Add the RefreshDataWorker class. WorkManager workers always extend a Worker class.
 * We're going to use a CoroutineWorker, because we want to use coroutines to handle our asynchronous code and threading.
 * Have RefreshDataWorker extend from the CoroutineWorker class.
 * You also need to pass a Context and WorkerParameters to the class and its parent class.
 */
class RefreshDataWorker(appContext: Context, params: WorkerParameters):
    CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    /**
     * A coroutine-friendly method to do your work.
     * This is what "work" your RefreshDataWorker does, in our case, syncing with the network.
     * Add variables for the database and the repository.
     */
    override suspend fun doWork(): Payload {
        val database = getDatabase(applicationContext)
        val repository = VideosRepository(database)
        /**
         * Use refresh the videos and call Payload() to return SUCCESS or RETRY.
         */
        return try {
            repository.refreshVideos()
            Payload(Result.SUCCESS)
        } catch (e: HttpException) {
            Payload(Result.RETRY)
        }
    }
}