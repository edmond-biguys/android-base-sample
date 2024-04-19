package com.cym.customerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.xmcc.androidbasesample.databinding.FragmentCustomerViewFisrtBinding

/**
 * Created by caoj on 2024/4/18.
 */
class FirstFragment: Fragment() {

    private lateinit var binding: FragmentCustomerViewFisrtBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomerViewFisrtBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
    }

    //tab上的title
    private val tabTitles = arrayOf("drawCircle", "drawPath")

    private fun initViewPager() {
        //需要显示的fragment加入到list
        fragments.add(CircleViewFragment())
        fragments.add(DrawPathFragment())

        //创建viewPager2的adapter
        val adapter = MyFragmentAdapter(requireActivity())
        binding.viewPager2.adapter = adapter

        val tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.viewPager2) {
            tabLayout, position ->
            tabLayout.text = tabTitles[position]
        }
        tabLayoutMediator.attach()
    }


    private val fragments = mutableListOf<Fragment>()
    inner class MyFragmentAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }

    }
}