package com.example.caloriesmonitor.screens.home.presentation

import android.os.Build
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.caloriesmonitor.core.models.domainmodels.Nutrients
import com.example.caloriesmonitor.core.ui.BaseMaterialDialogFragment
import com.example.caloriesmonitor.databinding.FragmentDialogNutrientsNormBinding
import com.example.caloriesmonitor.screens.home.domain.models.NutrientsNorm
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class NutritionNormDialogFragment: BaseMaterialDialogFragment<FragmentDialogNutrientsNormBinding>(
    FragmentDialogNutrientsNormBinding::inflate
) {

    private val textInputs: List<TextInputEditText> by lazy {
        listOf(
            binding.maxCaloriesEt,
            binding.maxCarbohydrateEt,
            binding.maxFatEt,
            binding.maxProteinEt
        )
    }

    private val argNutrientsNorm: NutrientsNorm? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getSerializable(NUTRIENTS_NEW_INSTANCE_ARG_KEY, NutrientsNorm::class.java)
        }else{
            requireArguments().getSerializable(NUTRIENTS_NEW_INSTANCE_ARG_KEY) as NutrientsNorm
        }
    }

    override fun prepareUi(savedInstanceState: Bundle?) {
        super.prepareUi(savedInstanceState)
        binding.maxProteinEt.setText(argNutrientsNorm!!.nutrientsStat.protein.toString())
        binding.maxFatEt.setText(argNutrientsNorm!!.nutrientsStat.fat.toString())
        binding.maxCaloriesEt.setText(argNutrientsNorm!!.nutrientsStat.calories.toString())
        binding.maxCarbohydrateEt.setText(argNutrientsNorm!!.nutrientsStat.carbohydrate.toString())
    }

    override fun prepareDialog(
        savedInstanceState: Bundle?,
        dialog: MaterialAlertDialogBuilder
    ): MaterialAlertDialogBuilder {

        dialog.apply {
            setNegativeButton("Отмена", null)
            setTitle("Норма БЖУ за день")

            setPositiveButton("Ок") { dialog, _ ->
                textInputs.forEach {
                    if (it.text.isNullOrBlank()){
                        it.setText("0.0")
                    }
                }
                val resultNutrientsNorm = NutrientsNorm(
                    argNutrientsNorm!!.date,
                    Nutrients(
                        binding.maxCaloriesEt.text.toString().toFloat(),
                        binding.maxFatEt.text.toString().toFloat(),
                        binding.maxProteinEt.text.toString().toFloat(),
                        binding.maxCarbohydrateEt.text.toString().toFloat()
                    )
                )
                setNutrientsNormResult(resultNutrientsNorm)
            }
        }

        return dialog
    }

    private fun setNutrientsNormResult(nutrientsNorm: NutrientsNorm){
        setFragmentResult(
            NUTRIENTS_DIALOG_RESULT_KEY,
            bundleOf(
                NUTRIENTS_BUNDLE_RESULT_KEY to nutrientsNorm
            )
        )
    }

    companion object{
        const val NUTRIENTS_DIALOG_RESULT_KEY = "NUTRIENTS_DIALOG_RESULT_KEY"
        const val NUTRIENTS_NEW_INSTANCE_ARG_KEY = "NUTRIENTS_NORM_KEY"
        const val NUTRIENTS_BUNDLE_RESULT_KEY = "NUTRIENTS_BUNDLE_RESULT_KEY"

        fun newInstance(nutrientsNorm: NutrientsNorm): NutritionNormDialogFragment {
            val args = Bundle()
            args.putSerializable(NUTRIENTS_NEW_INSTANCE_ARG_KEY,nutrientsNorm)
            val fragment = NutritionNormDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }
}