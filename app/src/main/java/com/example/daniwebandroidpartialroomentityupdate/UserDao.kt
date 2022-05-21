package com.example.daniwebandroidpartialroomentityupdate

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg users: User)

    @Update
    fun update(vararg users: User)

    @Delete
    fun delete(vararg users: User)

    @Query("UPDATE user SET name=:name WHERE id=:id")
    fun updateNameByQuery(id: Int, name: String)

    @Update(entity = User::class)
    fun updateName(userName: UserName)

    @Update(entity = User::class)
    fun updateAge(userAge: UserAge)
}