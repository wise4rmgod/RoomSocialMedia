package com.dev.roomsocialmedia.db

import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.dev.roomsocialmedia.db.model.Post
import com.dev.roomsocialmedia.db.model.SocialModel
import kotlinx.coroutines.flow.Flow


@Dao
interface SocialMediaDAO {

    @Query("SELECT * FROM post")
    fun showallpost(): List<Post>

    @Query("SELECT * FROM socialmedia")
    fun showallusers(): List<SocialModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(socialModel: SocialModel?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun post(post: Post)

    @Delete
    fun delete(socialModel: SocialModel)

    @Query("SELECT * FROM socialmedia WHERE email = :lemail AND password = :lpassword")
    fun login(lemail: String?, lpassword: String?): SocialModel

    @Update
    fun update_profile(socialModel: SocialModel)

    @Delete
    fun delete_account(socialModel: SocialModel)

}