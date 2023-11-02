package com.example.calculatorcompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculatorcompose.aos.CalculatorAction
import com.example.calculatorcompose.aos.CalculatorOperation
import com.example.calculatorcompose.aos.CalculatorState

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {

        when (action) {

            is CalculatorAction.Number -> {
                enterNumber(action.number)
            }

            is CalculatorAction.Decimal -> {
                enterDecimal()
            }

            is CalculatorAction.Operation -> {
                enterOperation(action.operation)
            }

            is CalculatorAction.Clear -> {
                state = CalculatorState()
            }


            is CalculatorAction.Delete -> {
                performDelete()
            }

            is CalculatorAction.Calculate -> {
                performCalculate()
            }

            else -> return


        }

    }

    private fun performCalculate() {

        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()


        if (state.number1.isNotBlank() && state.number2.isNotBlank()) {

            val result = when(state.operation){
                is CalculatorOperation.Add -> number1?.plus(number2 ?: 0.0)
                is CalculatorOperation.Subtract -> number1?.minus(number2 ?: 0.0)
                is CalculatorOperation.Multiply -> number1?.times(number2 ?: 0.0)
                is CalculatorOperation.Divide -> number1?.div(number2 ?: 0.0)
                else -> return
            }

            state = state.copy(number1 = result.toString().take(15), number2 = "", operation = null)

        }


    }

    private fun performDelete() {

        if (state.number1.isNotBlank() && state.operation == null) {
            state = state.copy(number1 = state.number1.dropLast(1))
        }

        if (state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2.dropLast(1))
        }

        if (state.operation != null && state.number2.isBlank()) {
            state = state.copy(operation = null)
        }

    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {

        if (state.number1.isNotBlank() && !state.number1.contains(".") && state.operation == null) {
            state = state.copy(number1 = state.number1 + ".")
            return
        }

        if (!state.number2.contains(".") && state.operation != null) {
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun enterNumber(number: Int) {

        if (state.operation == null) {

            if (state.number1.length >= MAX_NUMBER_LENGTH) {
                return
            }

            state = state.copy(number1 = state.number1 + number)
            return
        }

        if (state.number2.length >= MAX_NUMBER_LENGTH) {
            return
        }

        state = state.copy(number2 = state.number2 + number)


    }

    companion object {
        private const val MAX_NUMBER_LENGTH = 8
    }

}