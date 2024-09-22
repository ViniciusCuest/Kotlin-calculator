package com.fatec.calculadora.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import com.fatec.calculadora.ui.theme.Background

@Composable
fun StyledNumericField (value: String, label: String, onChange: (str: String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        textStyle = TextStyle(
            fontSize = 12.em,
            textAlign = TextAlign.Center
        ),
        label = {
            Text(text = label)
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .background(Background)
        ,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}