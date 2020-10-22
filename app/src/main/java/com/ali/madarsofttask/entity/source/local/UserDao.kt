package com.ali.madarsofttask.entity.source.local

import androidx.room.*
import com.ali.madarsofttask.entity.source.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser( user: User):Long


    @Query("SELECT * FROM  User")
     fun getAllUsers(): List<User>

    @Query("DELETE FROM User")
    suspend fun deleteAllUsers()


    @Delete
    suspend fun deleteUser(user: User)

}