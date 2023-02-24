package com.example.caloriesmonitor.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VB: ViewBinding>(
    private val bindingInflate: (layoutInflater: LayoutInflater,viewGroup: ViewGroup?, attach: Boolean) -> VB
): Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareUi(view)
    }

    abstract fun prepareUi(view: View)

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}