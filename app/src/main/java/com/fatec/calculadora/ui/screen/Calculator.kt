package com.fatec.calculadora.ui.screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatec.calculadora.ui.components.Display
import com.fatec.calculadora.ui.components.StyledButton
import com.fatec.calculadora.ui.components.StyledNumericField

@Preview(showBackground = true)
@Composable
fun Calculator() {
    val availableOperations = listOf("+", "-", "x", "/")

    var num1 by remember { mutableStateOf(TextFieldValue("")) }
    var num2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }
    var operation by remember { mutableStateOf("") }
    val display = remember { mutableStateOf(false) }
    val hasError = remember { mutableStateOf(false) }

    fun calculate(value: String, number1: Double, number2: Double): Double {
        return when (value) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "x" -> number1 * number2
            "/" -> number1 / number2
            else -> .0
        }
    }
    Column(
        modifier = Modifier
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Display(
            value1 = num1.text,
            value2 = num2.text,
            result = result,
            operator = operation,
            isShown = display.value
        )
        Column {
            StyledNumericField(
                value = num1.text,
                label = "1° Número",
                onChange = { num1 = TextFieldValue(it) }
            )
            StyledNumericField(
                value = num2.text,
                label = "2° Número",
                onChange = { num2 = TextFieldValue(it) }
            )
        }
        Column {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                reverseLayout = false,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                items(availableOperations) { operations ->
                    StyledButton(
                        title = operations,
                        error = hasError.value,
                        action = {
                            operation = operations
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                StyledButton(
                    title = "C",
                    error = null,
                    action = {
                        display.value = false
                        num1 = TextFieldValue("")
                        num2 = TextFieldValue("")
                        operation = ""
                        result = ""
                    }
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                StyledButton(
                    title = "=",
                    error = null,
                    action = {
                        val convertedNumber1 = num1.text.toDoubleOrNull()
                        val convertedNumber2 = num2.text.toDoubleOrNull()
                        if(operation.isEmpty()) {
                            hasError.value = true
                        }
                        if (convertedNumber1 != null && convertedNumber2 != null && operation.isNotEmpty()) {
                            result = calculate(number1 = convertedNumber1, number2 = convertedNumber2, value = operation).toString()
                            hasError.value = false
                            display.value = true
                        }
                    }
                )
            }
        }
    }
}