package com.fatec.calculadora.ui.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.fatec.calculadora.ui.theme.ActionItems
import com.fatec.calculadora.ui.theme.Blue900
import com.fatec.calculadora.ui.theme.Error
import com.fatec.calculadora.ui.theme.TextColor

@Composable
fun StyledButton (title: String, error: Boolean?, action: () -> Unit) {
    Button(
        onClick = action,
        colors = ButtonColors(
            containerColor = ActionItems,
            contentColor = TextColor,
            disabledContentColor = TextColor,
            disabledContainerColor = ActionItems,
        ),
        modifier = Modifier
            .background(color = ActionItems, shape = RoundedCornerShape(80.dp))
            .size(80.dp)
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(50.dp)),
        border = if (error == true) { BorderStroke(
            color = Error,
            width = 3.dp,
        )} else {
            null
        },
    ) {
        Text(
            text = title,
            fontSize = 12.em
        )
    }
}