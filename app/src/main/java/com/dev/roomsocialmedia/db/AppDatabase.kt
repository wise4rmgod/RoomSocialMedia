package com.dev.roomsocialmedia.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev.roomsocialmedia.db.model.Post
import com.dev.roomsocialmedia.db.model.SocialModel


@Database(entities = arrayOf(SocialModel::class, Post::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun socialmediadao(): SocialMediaDAO
}