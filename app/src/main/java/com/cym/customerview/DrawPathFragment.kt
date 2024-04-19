package com.cym.customerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xmcc.androidbasesample.databinding.FragmentDrawPathBinding

/**
 * Created by caoj on 2024/4/18.
 */
class DrawPathFragment: Fragment() {

    private lateinit var binding: FragmentDrawPathBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDrawPathBinding.inflate(inflater, container, false)
        return binding.root
    }
}