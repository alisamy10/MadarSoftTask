package com.ali.madarsofttask.entity.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.ali.madarsofttask.entity.source.model.User
import com.ali.madarsofttask.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.core.Is
import org.junit.*
import org.junit.runner.RunWith
import java.io.IOException
import org.hamcrest.core.Is.`is`
import org.junit.Test
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
@SmallTest
@ExperimentalCoroutinesApi
class UserDatabaseTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var dataDao: UserDao
    private lateinit var db: UserDatabase

    @Before
    fun createDb() {

        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UserDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        dataDao = db.getUserDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {

        db.close()
    }


    @Test
    fun insertAndGetData() = runBlockingTest {
        val fakeUser = User(
            name = "ali",
            gender = "male",
            age = 24,
            jobTitle = "android developer",
            id = 1
        )
        dataDao.insertUser(fakeUser)
        val allUsers = dataDao.getAllUsers().getOrAwaitValue()
        assertThat(allUsers).contains(fakeUser)
    }

    @Test
    fun deleteAllUsers() = runBlockingTest {
        val fakeUser = User(
            name = "ali",
            gender = "male",
            age = 24,
            jobTitle = "android developer",
            id = 1
        )
        dataDao.insertUser(fakeUser)
        dataDao.deleteAllUsers()
        val allUsers = dataDao.getAllUsers().getOrAwaitValue()
        assertThat(allUsers.size, `is`(0))

    }




    @Test
    fun deleteUser() = runBlockingTest {
        val fakeUser = User(
            name = "ali",
            gender = "male",
            age = 24,
            jobTitle = "android developer",
            id = 1
        )
        dataDao.insertUser(fakeUser)
        dataDao.deleteUser(fakeUser)
        val allUsers = dataDao.getAllUsers().getOrAwaitValue()
        assertThat(allUsers).doesNotContain(fakeUser)
    }

}

