package com.example.nerkhearzapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nerkhearzapp.R
import com.example.nerkhearzapp.databinding.FragmentDollarBinding
import com.example.nerkhearzapp.view.adapter.MyAdapter

class DollarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
     val binding = FragmentDollarBinding.inflate(LayoutInflater.from(activity) , container,false)


        val list = mutableListOf("Ali" , "Mahdi" , "Hasan")
        binding.DollarFragmentRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.DollarFragmentRecyclerView.adapter = MyAdapter(requireContext() , list)


        return binding.root
    }
}