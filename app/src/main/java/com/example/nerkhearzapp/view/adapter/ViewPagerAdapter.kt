package com.example.nerkhearzapp.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nerkhearzapp.view.fragment.DollarFragment
import com.example.nerkhearzapp.view.fragment.GoldFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            DollarFragment()
        else
            GoldFragment()
    }
}