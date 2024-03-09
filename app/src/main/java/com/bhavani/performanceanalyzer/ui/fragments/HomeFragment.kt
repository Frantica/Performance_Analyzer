package com.bhavani.performanceanalyzer.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bhavani.performanceanalyzer.databinding.FragmentHomeBinding
import com.bhavani.performanceanalyzer.ui.base.AbsBindingFragment


class HomeFragment : AbsBindingFragment<FragmentHomeBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater, container, false)

    companion object {
        fun instance() = HomeFragment()
    }
}