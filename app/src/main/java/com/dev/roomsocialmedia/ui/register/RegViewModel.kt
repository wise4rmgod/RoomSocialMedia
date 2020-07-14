package com.dev.roomsocialmedia.ui.register

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.dev.roomsocialmedia.db.model.SocialModel
import com.dev.roomsocialmedia.repository.SocialMediaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegViewModel @ViewModelInject constructor(
    private val socialMediaRepository: SocialMediaRepository
) :
    ViewModel() {
    // var socialModel = MutableLiveData()
    var socialModel: MutableLiveData<SocialModel> = MutableLiveData()
    val status: MutableLiveData<Boolean> = MutableLiveData()

    init {
        socialModel.value = SocialModel()
    }

    fun register() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                if (socialModel.value?.email != null) {
                    socialModel.value?.let {
                        val returnemail = socialMediaRepository.returnemail(it.email)
                        if (socialModel.value?.email != it.email)
                            socialMediaRepository.reg(it)
                        status.postValue(true)
                    }

                } else {
                    status.postValue(false)
                }

            }

        }
    }

    fun emailreturn(): Boolean {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                socialModel.value.let {
                    socialMediaRepository.returnemail(it?.email)
                }
            }
        }

        return true
    }

    val firstTodo: LiveData<List<SocialModel>> = liveData(Dispatchers.Main) {
        withContext(Dispatchers.IO) {
            val socialist = socialMediaRepository.myflow
            socialist.collect {
                emit(it)
            }
        }

    }
}