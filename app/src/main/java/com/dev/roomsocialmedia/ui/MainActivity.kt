package com.dev.roomsocialmedia.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.roomsocialmedia.R
import com.dev.roomsocialmedia.db.SocialMediaDAO
import com.dev.roomsocialmedia.db.model.SocialModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}