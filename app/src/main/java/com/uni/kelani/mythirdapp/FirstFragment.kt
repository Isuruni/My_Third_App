package com.uni.kelani.mythirdapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.uni.kelani.mythirdapp.adapter.PhotoAdapter
import com.uni.kelani.mythirdapp.api.PhotoAPIService
import com.uni.kelani.mythirdapp.databinding.FragmentFirstBinding
import com.uni.kelani.mythirdapp.model.Photos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val photoAPIService = PhotoAPIService.create()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.layoutManager = LinearLayoutManager(view.context)
       /* val photo= photoAPIService.getPhotos();

        photo.enqueue(object : Callback<List<Photos>>{
            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                val body = response.body()
                body?.let {
                  val photoBody= response.body()
                  val adapter= PhotoAdapter(photoBody!!)
                    binding.recyclerview.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
                Log.i("FirstFragment", t.message!!)
            }
            /*binding.buttonFirst.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }*/

    })*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}