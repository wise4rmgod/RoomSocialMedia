package com.dev.roomsocialmedia.ui.login

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dev.roomsocialmedia.db.AppDatabase
import com.dev.roomsocialmedia.db.SocialMediaDAO
import com.dev.roomsocialmedia.db.model.SocialModel
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginViewModelTest {

    private lateinit var socialMediaDAO: SocialMediaDAO
    private lateinit var appDatabase: AppDatabase

    @Before
    fun setUpDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDatabase = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        socialMediaDAO = appDatabase.socialmediadao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        appDatabase.close()
    }

    @Test
    fun getSocialModel() {
    }

    @Test
    fun setSocialModel() {
    }

    @Test
    fun getStatus() {
    }

    @Test
    @Throws(Exception::class)
    fun login() {

        val import = ""
      /**  val user: SocialModel = TestUtil.createUser(3).apply {
            setName("george")
        } **/

    }
}