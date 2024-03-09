package com.bhavani.performanceanalyzer.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class AbsBindingFragment<VB : ViewBinding> : Fragment() {

    private var _viewBinding: VB? = null

    protected val viewBinding: VB
        get() = _viewBinding ?: throw NullPointerException("ViewBinding is not initialised")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = initBinding(inflater, container)
        return _viewBinding?.root
    }


    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

}