package com.mertgundogan.welcalmclone.ui.greeting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mertgundogan.welcalmclone.databinding.FragmentGreetingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GreetingFragment : Fragment() {

    private val viewModel: GreetingViewModel by viewModels()
    private var _binding: FragmentGreetingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGreetingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToLoginFragment.setOnClickListener {
            actionToLoginFragment()
        }

    }

    private fun actionToLoginFragment() {
        val action = GreetingFragmentDirections.actionGreetingFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}