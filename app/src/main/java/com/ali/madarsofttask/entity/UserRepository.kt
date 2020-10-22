package com.ali.madarsofttask.entity

import com.ali.madarsofttask.entity.source.local.IOfflineDataSource
import com.ali.madarsofttask.entity.source.model.User
import javax.inject.Inject

class UserRepository  @Inject constructor(private val offlineDataSource: IOfflineDataSource){


    fun getAllUsers(): List<User> = offlineDataSource.getAllUsers()

    suspend fun insertUser(user : User){
        offlineDataSource.insertUser(user)
    }

    suspend fun deleteAllUsers(){
        offlineDataSource.deleteAllUsers()
    }

    suspend fun deleteUser(user: User){
        offlineDataSource.deleteUser(user)
    }
}