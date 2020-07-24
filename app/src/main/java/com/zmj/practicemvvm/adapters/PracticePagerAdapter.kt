package com.zmj.practicemvvm.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zmj.practicemvvm.GardenFragment
import com.zmj.practicemvvm.PlantListFragment

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/7/24
 * Description :
 */

const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1

class PracticePagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment){

    private val tabFragmentCreators: Map<Int,() -> Fragment> = mapOf(
        MY_GARDEN_PAGE_INDEX to {GardenFragment()},
        PLANT_LIST_PAGE_INDEX to {PlantListFragment()}
    )

    override fun getItemCount() = tabFragmentCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}