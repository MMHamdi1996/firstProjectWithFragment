package com.example.nerkhearzapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nerkhearzapp.R
import com.example.nerkhearzapp.databinding.FragmentDollarBinding
import com.example.nerkhearzapp.view.ApiService
import com.example.nerkhearzapp.view.DataClass
import com.example.nerkhearzapp.view.adapter.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DollarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDollarBinding.inflate(LayoutInflater.from(activity), container, false)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://sharifmehr.com/")
            .build()

        val apiService : ApiService = retrofit.create(ApiService::class.java)
        val call = apiService.getData()
        call.enqueue(object : Callback<MutableList<DataClass>>{
            override fun onResponse(
                p0: Call<MutableList<DataClass>>,
                p1: Response<MutableList<DataClass>>,
            ) {
            }

            override fun onFailure(p0: Call<MutableList<DataClass>>, p1: Throwable) {
            }

        })


        val list = mutableListOf("Ali", "Mahdi", "Hasan")
        binding.DollarFragmentRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.DollarFragmentRecyclerView.adapter = MyAdapter(requireContext(), list)


        return binding.root
    }
}