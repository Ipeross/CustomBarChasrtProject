package com.custombarchasrtproject

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BarChart() {
    val chartData = listOf(
        Pair("1", 50),
        Pair("2", 70),
        Pair("3", 200),
        Pair("4", 45),
        Pair("5", 8),
        Pair("6", 85),
        Pair("6", 85),
        Pair("6", 85),
    )

    val textMeasurer = rememberTextMeasurer()

    val upperValue = remember { (chartData.maxOfOrNull { it.second }?.plus(1)) ?: 0 }

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.LightGray)
            .padding(15.dp)
    ) {

        val canvasHeight = size.height
        val canvasWidth = size.width

        val spacePerData = (canvasWidth) / chartData.size

        chartData.forEachIndexed { index, chartPair ->
            val width = 70f

            val height = (chartPair.second.toFloat() / upperValue) * canvasHeight
            val textMeasured = textMeasurer.measure(
                text = chartPair.second.toString(),
                style = TextStyle(fontSize = 15.sp)
            )

            val textX = index * spacePerData
            val textY = canvasHeight

            drawText(
                textLayoutResult = textMeasured,
                topLeft = Offset(textX, textY)
            )

            drawRoundRect(
                color = Color.Red,
                topLeft = Offset(
                    index * spacePerData,
                    (upperValue - chartPair.second.toFloat()) / upperValue * canvasHeight
                ),
                size = Size(
                    width,
                    height
                ),
            )
        }

    }
}