package com.ali.madarsofttask.entity.source.local

import com.ali.madarsofttask.entity.source.model.User

interface IOfflineDataSource {


     fun getAllUsers(): List<User> = emptyList()

    suspend fun insertUser(user : User){}

    suspend fun deleteAllUsers(){}

    suspend fun deleteUser(user: User){}
}