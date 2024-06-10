package com.example.uas_anmp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uas_anmp.util.DB_NAME
import com.example.uas_anmp.util.MIGRATION_USER_1_2


@Database(entities = [User::class], version =  2)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var instance: UserDatabase? = null
        private val LOCK = Any()

        fun buildDatabase(context: Context): UserDatabase {
            synchronized(LOCK) {
                return instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    DB_NAME
                )
                    .addMigrations(MIGRATION_USER_1_2)
                    .build().also {
                        instance = it
                    }
            }
        }

        fun buildDatabase(): UserDatabase {
            TODO("Provide implementation if needed")
        }
    }
}