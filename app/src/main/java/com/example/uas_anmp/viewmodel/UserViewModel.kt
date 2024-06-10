package com.example.uas_anmp.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_anmp.model.User
import com.example.uas_anmp.model.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(private val userDatabase: UserDatabase) : ViewModel() {

    // Konstruktor nol argumen
    constructor() : this(UserDatabase.buildDatabase())


    // Fungsi untuk memasukkan data pengguna ke database
    fun insertUser(
        user: String,
        password: String,
        email: String,
        firstName: String,
        lastName: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            userDatabase.userDao().insertuser(user)
        }
    }

    // Fungsi untuk mendapatkan pengguna berdasarkan username
    fun getUserByUsername(username: String): User? {
        return userDatabase.userDao().selectuserByusername(username)
    }
}
