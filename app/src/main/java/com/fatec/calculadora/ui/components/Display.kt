package com.fatec.calculadora.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.fatec.calculadora.ui.theme.ActionItems

@Composable
fun Display(isShown: Boolean, result: String, value1: String, value2: String, operator: String) {
    Column (
        modifier = Modifier.height(120.dp).fillMaxWidth()
    ) {
        if (isShown) {
            Row {
                Text(
                    text = "$value1 $operator $value2",
                    fontSize = 8.em,
                    color = ActionItems
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = result,
                    fontSize = 20.em,
                    color = ActionItems
                )
            }
        }
    }
}