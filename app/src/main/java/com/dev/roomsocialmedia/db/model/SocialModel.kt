package com.dev.roomsocialmedia.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "socialmedia")
data class SocialModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var fullname: String? = null,
    var email: String? = null,
    var password: String? = null,
    var age: Int? = null,
    var phone: String? = null
)