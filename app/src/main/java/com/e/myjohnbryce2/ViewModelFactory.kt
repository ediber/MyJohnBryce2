package com.e.myjohnbryce2

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory (private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ViewModelFactory::class.java)){
            return Fragment0ViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}