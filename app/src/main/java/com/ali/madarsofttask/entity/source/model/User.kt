package com.ali.madarsofttask.entity.source.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val name: String?=null,
    val age: Int?=0,
    val gender: String?=null,
    val jobTitle: String?=null )