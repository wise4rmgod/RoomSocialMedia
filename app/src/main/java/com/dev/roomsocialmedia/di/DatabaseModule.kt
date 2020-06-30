package com.dev.roomsocialmedia.di

import android.content.Context
import androidx.room.Room
import com.dev.roomsocialmedia.HiltApplication
import com.dev.roomsocialmedia.db.AppDatabase
import com.dev.roomsocialmedia.db.SocialMediaDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, "social.db"
        )
            .build()
    }

    @Provides
    fun provideLogDao(database: AppDatabase): SocialMediaDAO {
        return database.socialmediadao()
    }

}