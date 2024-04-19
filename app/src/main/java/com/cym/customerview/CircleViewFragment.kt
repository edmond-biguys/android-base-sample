package com.cym.customerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xmcc.androidbasesample.databinding.FragmentCircleViewBinding

/**
 * Created by caoj on 2024/4/18.
 */
class CircleViewFragment: Fragment() {

    private lateinit var binding: FragmentCircleViewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCircleViewBinding.inflate(inflater, container, false)

        return binding.root
    }
}