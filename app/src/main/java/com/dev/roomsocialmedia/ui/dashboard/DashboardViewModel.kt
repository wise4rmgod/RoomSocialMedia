package com.dev.roomsocialmedia.ui.dashboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.dev.roomsocialmedia.db.model.Post
import com.dev.roomsocialmedia.repository.SocialMediaRepository
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DashboardViewModel @ViewModelInject constructor(
    private val socialMediaRepository: SocialMediaRepository
) :
    ViewModel() {
    //   var post = Post()
    val status = MutableLiveData<Boolean>()
    fun sendpost(post: Post) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                socialMediaRepository.post(post)
                status.postValue(true)
            }
        }
    }

    val getpost: LiveData<List<Post>> = liveData(Dispatchers.Main) {
        withContext(Dispatchers.IO) {
            val socialist = socialMediaRepository.post
            socialist.collect {
                emit(it)
            }
        }

    }


}