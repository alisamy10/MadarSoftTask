package com.ali.madarsofttask.presentation

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ali.madarsofttask.entity.source.model.User
import com.ali.madarsofttask.entity.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel @ViewModelInject constructor(private val userRepository: UserRepository) :
    ViewModel() {


    val userNameError = MutableLiveData<Boolean>(false)
    val jobTitleError = MutableLiveData<Boolean>(false)
    val ageError = MutableLiveData<Boolean>(false)


    fun saveUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.insertUser(user)
        }
    }

     fun getSavedUsers() : LiveData<List<User>> {

       return userRepository.getAllUsers()

    }
    fun deleteUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.deleteUser(user)
    }

    fun deleteAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        userRepository.deleteAllUsers()
    }


}
