package com.uni.kelani.mythirdapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.uni.kelani.mythirdapp.database.AppDatabase
import com.uni.kelani.mythirdapp.databinding.FragmentSecondBinding
import com.uni.kelani.mythirdapp.model.Locations

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_OpenFragment)
        }

        binding.buttonFirst.setOnClickListener {
            val db= AppDatabase.getDatabase(view.context)

            val locationId = binding.editTextFirst.text.toString()
            val locationName = binding.editTextSecond.text.toString()
            val latitude = binding.editTextThird.text.toString().toDouble()
            val longitude = binding.editTextFourth.toString().toDouble()
            val location = Locations(locationId,locationName,latitude,longitude)

            db.locationsDao().insertAll(location)

            findNavController().navigate(R.id.action_SecondFragment_to_OpenFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}