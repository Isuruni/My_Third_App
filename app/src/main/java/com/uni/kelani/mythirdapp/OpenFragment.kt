package com.uni.kelani.mythirdapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.uni.kelani.mythirdapp.api.PhotoAPIService
import com.uni.kelani.mythirdapp.databinding.FragmentOpenBinding

class OpenFragment : Fragment() {

    private var _binding: FragmentOpenBinding? = null
    private val photoAPIService = PhotoAPIService.create()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOpenBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding.buttonFirst.setOnClickListener {
                findNavController().navigate(R.id.action_OpenFragment_to_FirstFragment)
            }

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_OpenFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}