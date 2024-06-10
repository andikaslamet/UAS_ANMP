package com.example.uas_anmp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertuser(vararg user: String)

    @Query("SELECT * FROM User")
    fun selectAllUsers(): List<User>

    @Query("SELECT * FROM User WHERE username = :username")
    fun selectuserByusername(username: String): User?

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)
}

