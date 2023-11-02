package com.example.calculatorcompose.aos

sealed class CalculatorOperation(val operation: String) {

    object Add : CalculatorOperation("+")
    object Subtract : CalculatorOperation("-")
    object Multiply : CalculatorOperation("×")
    object Divide : CalculatorOperation("/")

}
