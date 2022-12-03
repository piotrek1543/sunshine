package com.example.sunshine.ui.weather

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sunshine.R
import com.example.sunshine.domain.weather.WeatherData
import com.example.sunshine.ui.theme.SunshineTheme
import java.time.LocalDateTime

@Composable
fun WeatherDataDisplay(
    value: Int?,
    unit: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    iconTint: Color = Color.White
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "$value$unit",
            style = textStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherDataDisplay() {
    SunshineTheme {
        val data = WeatherData(
            id = 0,
            time = LocalDateTime.now(),
            weatherCode = 0,
            pressure = 0.0,
            temperatureCelsius = 0.0,
            windSpeed = 0.0,
            humidity = 0,
        )
        WeatherDataDisplay(
            value = data.windSpeed?.toInt(),
            unit = "km/h",
            icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
            iconTint = Color.White,
            textStyle = TextStyle(color = Color.White)
        )
    }
}
