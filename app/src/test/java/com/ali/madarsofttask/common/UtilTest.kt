package com.ali.madarsofttask.common

import com.ali.madarsofttask.entity.source.model.User
import org.hamcrest.core.Is.`is`
import org.junit.Test
import org.junit.Assert.*

class UtilTest {

    @Test
    fun searchQuery_addFakeList_returnTheSizeOfNewListWithMatchedTitle (){
        val fakeList = mutableListOf<User>().apply {
            add(User(name = "ahmed",age = 20,jobTitle = "software engineer",id = 1 ))
            add(User(name = "ali",age = 24,jobTitle = "android engineer",id = 2))
            add(User(name = "sara",age = 17,jobTitle = " student",id = 3))
            add(User(name = "mona",age = 20,jobTitle = "sdoctor",id = 4))
        }
        val result="o".searchQuery(fakeList)
        assertThat(result?.size, `is`(1))
    }
    @Test
    fun searchQuery_addNullList_returnZeroSize (){
        val result="o".searchQuery(null)
        assertThat(result?.size, `is`(0))
    }
    @Test
    fun searchQuery_addEmptyList_returnZeroSize (){
        val result="o".searchQuery(emptyList())
        assertThat(result?.size, `is`(0))
    }

}