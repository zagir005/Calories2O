package com.example.caloriesmonitor.core.extensions

import androidx.core.widget.doBeforeTextChanged
import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.doIfTextEmpty(block: (textInputEt: TextInputEditText)-> Unit){
    doBeforeTextChanged { text, start, count, after ->
        if (text.isNullOrBlank()){
            block(this)
        }
    }
}