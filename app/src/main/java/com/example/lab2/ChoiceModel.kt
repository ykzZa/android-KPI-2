package com.example.lab2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class ChoiceModel : ViewModel() {
    val choice : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}