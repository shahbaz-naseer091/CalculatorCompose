package com.example.calculatorcompose.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorcompose.aos.CalculatorAction
import com.example.calculatorcompose.aos.CalculatorOperation
import com.example.calculatorcompose.aos.CalculatorState
import com.example.calculatorcompose.ui.ui.theme.black
import com.example.calculatorcompose.ui.ui.theme.orange

@Composable
fun Calculator(
    modifier: Modifier,
    state: CalculatorState,
    buttonSpace: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpace)
        ) {
            Text(
                text = state.number1 + (state.operation?.operation ?: "") + state.number2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
                    .align(Alignment.End),
                fontSize = 48.sp,
                color = Color.Black,
                maxLines = 2,
                fontWeight = FontWeight.Light
            )

            //First Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                //Clear button
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(2f)
                        .weight(2f),
                    onclick = {
                        onAction(CalculatorAction.Clear)
                    }
                )
                //Delete button
                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Delete)
                    }
                )

                // `/. button
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                )
            }

            //Second Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                //7 button
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Number(7))
                    }
                )
                //8 button
                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Number(8))
                    }
                )

                //9 button
                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Number(9))
                    }
                )

                // * button
                CalculatorButton(
                    symbol = "*",
                    modifier = Modifier
                        .background(orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
                )
            }

            //Third Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                //4 button
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Number(4))
                    }
                )
                //5 button
                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Number(5))
                    }
                )

                //9 button
                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Number(6))
                    }
                )

                // - button
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }
                )
            }

            //Fourth Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                //1 button
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Number(1))
                    }
                )
                //2 button
                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Number(2))
                    }
                )

                //3 button
                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Number(3))
                    }
                )

                // + button
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                )
            }

            //Fifth Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                //0 button
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(2f)
                        .weight(2f),
                    onclick = {
                        onAction(CalculatorAction.Number(0))
                    }
                )
                // . button
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Decimal)
                    }
                )

                //= button
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Calculate)
                    }
                )

            }


        }
    }
}