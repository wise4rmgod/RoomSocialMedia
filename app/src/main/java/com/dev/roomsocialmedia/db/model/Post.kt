package com.dev.roomsocialmedia.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class Post(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var post: String? = null,
    var background_color: String? = null
)