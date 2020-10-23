package com.ali.madarsofttask.entity.source.local

import androidx.lifecycle.LiveData
import com.ali.madarsofttask.entity.source.model.User

interface IOfflineDataSource {


     fun getAllUsers(): LiveData<List<User>>

    suspend fun insertUser(user : User){}

    suspend fun deleteAllUsers(){}

    suspend fun deleteUser(user: User){}
}