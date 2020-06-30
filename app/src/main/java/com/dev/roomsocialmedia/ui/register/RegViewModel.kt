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
    var socialModel: SocialModel? = null
    val test = MutableLiveData(socialModel)
    val status: MutableLiveData<Boolean> = MutableLiveData()

    init {
        test.value = SocialModel()
    }

    fun register() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (test.value?.email == null) {
                    socialMediaRepository.reg(socialModel)
                    status.postValue(true)
                } else {
                    status.postValue(false)
                }
                // socialModel.value.let {  socialMediaRepository.reg(socialModel)}
                //  socialMediaRepository.reg(socialModel.value!!)
            }

        }
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