package com.arthlimchiu.unit_testing_live_data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _user = MutableLiveData<User>()

    val user: LiveData<User>
        get() = _user

    fun fetchUser(id: Int) {
        val user = User(id)

        _user.value = user
    }
}