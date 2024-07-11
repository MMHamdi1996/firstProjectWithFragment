package com.example.nerkhearzapp.view.fragment

import android.os.Bundle
import android.util.Log
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
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class DollarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDollarBinding.inflate(LayoutInflater.from(activity), container, false)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://sharifmehr.com/")
            .build()

        val apiService: ApiService = retrofit.create(ApiService::class.java)
        val call = apiService.getData()
        call.enqueue(object : Callback<String> {
            override fun onResponse(p0: Call<String>, p1: Response<String>) {

                val jsonObject = JSONObject(p1.body())
                val jsonObject2 = jsonObject.getJSONObject("sana")
                val jsonArray = jsonObject2.getJSONArray("data")

                val titleList = mutableListOf<String>()
                val priceList = mutableListOf<String>()
                for (i in 0 until jsonArray.length()) {
                    titleList.add(jsonArray.getJSONObject(i).get("title").toString())
                    priceList.add(jsonArray.getJSONObject(i).get("p").toString())
                }
                binding.DollarFragmentRecyclerView.adapter = MyAdapter(titleList, priceList)
                binding.DollarFragmentRecyclerView.layoutManager = LinearLayoutManager(activity)
            }

            override fun onFailure(p0: Call<String>, p1: Throwable) {
                Log.d("dataE", "" + p1.message)
            }
        })


        return binding.root
    }
}