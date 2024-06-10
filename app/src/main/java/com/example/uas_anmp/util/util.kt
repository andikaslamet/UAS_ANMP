package com.example.uas_anmp.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.uas_anmp.model.UserDatabase


val DB_NAME = "userdb"
fun buildUserDb(context: Context): UserDatabase {
    return UserDatabase.buildDatabase(context)
}

val MIGRATION_USER_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE user ADD COLUMN id INTEGER DEFAULT 3 not null")
    }
}