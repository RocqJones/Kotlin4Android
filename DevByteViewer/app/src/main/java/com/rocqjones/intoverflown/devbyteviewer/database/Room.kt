package com.rocqjones.intoverflown.devbyteviewer.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VideoDao {
    @Query("select * from databasevideo")
    fun getVideos(): LiveData<List<DatabaseVideo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg videos: DatabaseVideo)
}

/**
 * Create an abstract VideosDatabase class that extends RoomDatabase, and annotate it with @Database, including entities and version.
 */
@Database(entities = [DatabaseVideo::class], version = 1)
abstract class VideosDatabase : RoomDatabase() {
    // add an abstract videoDao variable.
    abstract val videoDao: VideoDao
}

// TODO Define an INSTANCE variable to store the singleton.
private lateinit var INSTANCE: VideosDatabase

/**
 * getDatabase() function to return the VideosDatabase:
 * use ::INSTANCE.isInitialized to check if the variable has been initialized. If it hasn't, then initialize it.
 */
fun getDatabase(context: Context): VideosDatabase {
    synchronized(VideosDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                VideosDatabase::class.java,
                "videos").build()
        }
    }
    return INSTANCE
}