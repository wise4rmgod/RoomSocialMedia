package com.dev.roomsocialmedia.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.roomsocialmedia.db.model.SocialModel
import com.dev.roomsocialmedia.repository.SocialMediaRepository
import com.squareup.okhttp.Dispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel @ViewModelInject constructor(private val socialMediaRepository: SocialMediaRepository) :
    ViewModel() {

    val socialModel = SocialModel()
    val status = MutableLiveData<Boolean>()
    fun login() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                socialMediaRepository.login(socialModel.email, socialModel.password)
                if (socialModel.email != null) {
                    status.postValue(true)
                } else status.postValue(false)

            }
        }
    }
}

