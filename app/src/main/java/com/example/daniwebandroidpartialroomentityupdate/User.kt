package com.example.daniwebandroidpartialroomentityupdate

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: Int = 1,
    val name: String,
    val age: Int
)

class UserName(
    val id: Int = 1,
    val name: String
)

class UserAge(
    val id: Int = 1,
    val age: Int
)