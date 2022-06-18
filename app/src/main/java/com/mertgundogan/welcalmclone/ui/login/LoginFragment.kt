package com.mertgundogan.welcalmclone.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.mertgundogan.welcalmclone.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            buttonLogin.setOnClickListener {
                loginControl(textInputEmail.text.toString(), textInputPassword.text.toString())
            }
        }

    }

    override fun onStart() {
        super.onStart()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.isUserLogin.observe(viewLifecycleOwner) {
            it?.let {
                if (it) {
                    actionToHome()
                }
            }
        }
    }

    private fun loginControl(email: String, password: String) {
        var control = true
        if (control) {
            viewModel.loginFirebaseAuth(email, password)
        } else {

        }
    }

    private fun actionToHome() {
        Toast.makeText(this.context, "BASARILI", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}