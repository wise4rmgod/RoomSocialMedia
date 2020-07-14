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

    var socialModel: MutableLiveData<SocialModel> = MutableLiveData()
    val status = MutableLiveData<String>()

    init {
        socialModel.value = SocialModel()
    }

    fun login() {
        viewModelScope.launch {
            val ty = checkfornullable()
            withContext(Dispatchers.IO) {
                socialModel.value.let {

                    val socialmodelg = socialMediaRepository.login(it?.email, it?.password)

                    if (!socialModel.value?.email.isNullOrEmpty() && !socialModel.value?.password.isNullOrEmpty()) {
                        if (socialmodelg != null) {
                            status.postValue("true")
                        } else {
                            status.postValue("false")
                        }

                    } else {
                        status.postValue("p")
                    }
                }
            }
        }
    }

    fun checkfornullable(): Boolean? {

        return socialModel.value?.email?.isNotBlank()
        // socialModel.value?.password?.isNotEmpty()
    }


}

