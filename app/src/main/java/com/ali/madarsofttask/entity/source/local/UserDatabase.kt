package com.ali.madarsofttask.entity.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ali.madarsofttask.entity.source.model.User

@Database(entities = [User::class], version = 1 , exportSchema = false)

abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}