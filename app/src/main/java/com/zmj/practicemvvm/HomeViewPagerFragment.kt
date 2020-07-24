package com.zmj.practicemvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.zmj.practicemvvm.adapters.MY_GARDEN_PAGE_INDEX
import com.zmj.practicemvvm.adapters.PLANT_LIST_PAGE_INDEX
import com.zmj.practicemvvm.adapters.PracticePagerAdapter
import com.zmj.practicemvvm.databinding.FragmentViewPagerBinding
import java.lang.IndexOutOfBoundsException

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/24
 * Description :
 */
class HomeViewPagerFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPagerBinding.inflate(inflater,container,false)

        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = PracticePagerAdapter(this)

        TabLayoutMediator(tabLayout,viewPager){tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when(position){
            MY_GARDEN_PAGE_INDEX -> R.drawable.garden_tab_selector
            PLANT_LIST_PAGE_INDEX -> R.drawable.garden_tab_selector
            else ->throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when(position){
            MY_GARDEN_PAGE_INDEX -> getString(R.string.my_garden_title)
            PLANT_LIST_PAGE_INDEX -> getString(R.string.plan_list_title)
            else -> null
        }
    }
}