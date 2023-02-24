package com.example.caloriesmonitor.screens.home.presentation

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentResultListener
import com.example.caloriesmonitor.core.extensions.logPrint
import com.example.caloriesmonitor.core.models.domainmodels.Nutrients
import com.example.caloriesmonitor.core.ui.BaseFragment
import com.example.caloriesmonitor.databinding.FragmentHomeBinding
import com.example.caloriesmonitor.screens.home.domain.models.NutrientsNorm
import java.util.*

class HomeFragment: BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate), FragmentResultListener {

    override fun prepareUi(view: View) {
        binding.settingsBtn.setOnClickListener {
            NutritionNormDialogFragment.newInstance(
                NutrientsNorm(
                    Date(),
                    Nutrients(
                        0f,0f,0f,0f,
                    )
                )
            ) .apply {

            }.show(
                childFragmentManager, "nutritionNormDialogFragment"
            )
            childFragmentManager.setFragmentResultListener(
                NutritionNormDialogFragment.NUTRIENTS_DIALOG_RESULT_KEY,
                this,
                this
            )
        }
    }

    override fun onFragmentResult(requestKey: String, result: Bundle) {
        if (NutritionNormDialogFragment.NUTRIENTS_DIALOG_RESULT_KEY == requestKey){
            val nutritionNorm = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                result.getSerializable(NutritionNormDialogFragment.NUTRIENTS_BUNDLE_RESULT_KEY,NutrientsNorm::class.java)
            }else{
                result.getSerializable(NutritionNormDialogFragment.NUTRIENTS_BUNDLE_RESULT_KEY) as NutrientsNorm
            }
        }
    }
}