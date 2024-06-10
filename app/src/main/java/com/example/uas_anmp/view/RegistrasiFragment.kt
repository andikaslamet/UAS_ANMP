package com.example.uas_anmp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.uas_anmp.databinding.FragmentRegistrasiBinding
import com.example.uas_anmp.viewmodel.UserViewModel

class RegistrasiFragment : Fragment() {
    private lateinit var binding: FragmentRegistrasiBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi UserViewModel dengan UserDatabase dari activity
        userViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(UserViewModel::class.java)

        binding.btnRegistrasi.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val username = binding.txtUsername.text.toString().trim()
        val password = binding.txtPassword.text.toString().trim()
        val email = binding.txtEmail.text.toString().trim()
        val firstName = binding.txtFirstName.text.toString().trim()
        val lastName = binding.txtLastName.text.toString().trim()

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() ||
            firstName.isEmpty() || lastName.isEmpty()
        ) {
            Toast.makeText(requireContext(), "Data Tidak Boleh Ada Yang kosong", Toast.LENGTH_LONG).show()
            return
        }

        // Memanggil fungsi insertUser dari UserViewModel untuk menyimpan data pengguna
        userViewModel.insertUser(username, password, email, firstName, lastName)

        Toast.makeText(requireContext(), "Registrasi Berhasil", Toast.LENGTH_LONG).show()
        Navigation.findNavController(binding.root).popBackStack()
    }
}
