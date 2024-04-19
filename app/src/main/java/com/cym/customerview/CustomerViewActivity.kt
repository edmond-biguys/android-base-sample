package com.cym.customerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xmcc.androidbasesample.databinding.ActivityCustomerViewBinding

/**
 * Created by caoj on 2024/4/18.
 */
class CustomerViewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCustomerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerViewBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }
}