package com.dev.roomsocialmedia.repository

import androidx.lifecycle.MutableLiveData
import com.dev.roomsocialmedia.db.AppDatabase
import com.dev.roomsocialmedia.db.model.Post
import com.dev.roomsocialmedia.db.model.SocialModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SocialMediaRepository @Inject constructor(appDatabase: AppDatabase) {

    private val socialMediaDAO = appDatabase.socialmediadao()

    fun reg(socialModel: SocialModel?) {
        socialMediaDAO.insert(socialModel)
    }

    fun login(email: String?, password: String?): SocialModel {
        return socialMediaDAO.login(email, password)
    }

    fun returnemail(email: String?): SocialModel {
        return socialMediaDAO.returnemailonly(email)
    }

    fun getpost() = socialMediaDAO.showallpost()

    fun getreglist() = socialMediaDAO.showallusers()

    var post = flow {
        emit(getpost())
    }

    var myflow = flow {
        emit(getreglist())
    }

    fun post(post: Post) {
        socialMediaDAO.post(post)
    }
}