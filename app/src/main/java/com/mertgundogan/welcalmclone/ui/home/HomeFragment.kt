package com.mertgundogan.welcalmclone.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.mertgundogan.welcalmclone.R
import com.mertgundogan.welcalmclone.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var exoPlayer: ExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val videoPath = RawResourceDataSource.buildRawResourceUri(R.raw.home_video).toString()

        exoPlayer = ExoPlayer.Builder(this.requireContext()).build()
        val mediaIt = MediaItem.fromUri(videoPath)
        exoPlayer.setMediaItem(mediaIt)

        binding.apply {
            exoView.player = exoPlayer

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}