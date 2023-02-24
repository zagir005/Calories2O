package com.example.caloriesmonitor.core.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

abstract class BaseMaterialDialogFragment<VB: ViewBinding>(
    private val bindingInflate: (layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attach: Boolean) -> VB
): DialogFragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    open fun prepareUi(savedInstanceState: Bundle?){

    }

    private fun prepareBinding(): View{
        _binding = bindingInflate.invoke(layoutInflater,null,false)
        return binding.root
    }

    abstract fun prepareDialog(
        savedInstanceState: Bundle?,
        dialog: MaterialAlertDialogBuilder
    ): MaterialAlertDialogBuilder

    open fun onDialogCreated(alertDialog: AlertDialog) {}

    final override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflatedDialogFragment = MaterialAlertDialogBuilder(requireContext()).apply {
            setView(prepareBinding())
        }
        return prepareDialog(
            savedInstanceState,
            inflatedDialogFragment
        ).setCancelable(false).create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareUi(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        onDialogCreated(requireDialog() as AlertDialog)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}