package com.ali.madarsofttask.entity.source.local

import com.ali.madarsofttask.entity.source.model.User
import javax.inject.Inject

class OfflineSourcesRoomBasedImpl  @Inject constructor (private val userDao: UserDao) : IOfflineDataSource  {

    override  fun getAllUsers() = userDao.getAllUsers()


    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }


    override suspend fun deleteAllUsers() {
      userDao.deleteAllUsers()
    }

    override suspend fun deleteUser(user: User) {
       userDao.deleteUser(user)
    }
}

