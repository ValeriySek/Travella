package com.app.travella.android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {

    fun getData(): LiveData<Test> {
        Log.i("TAGGG", "MainViewModel getData")
        return liveData {
            mainRepository.getData().body()?.let {
                Log.i("TAGGG", "MainViewModel getData it $it" )
                emit(it)
            }
        }
    }
}