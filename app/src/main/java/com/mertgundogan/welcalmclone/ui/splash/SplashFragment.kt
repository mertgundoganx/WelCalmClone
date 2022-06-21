package com.mertgundogan.welcalmclone.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mertgundogan.welcalmclone.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private val viewModel: SplashViewModel by viewModels()
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.isUserLogin.observe(viewLifecycleOwner) {
            it?.let {
                if (it) {
                    actionToHomeFragment()
                } else {
                    actionToLoginFragment()
                }
            }
        }
    }

    private fun actionToLoginFragment() {
        val action = SplashFragmentDirections.actionSplashFragmentToGreetingFragment()
        findNavController().navigate(action)
    }

    private fun actionToHomeFragment() {
        val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}