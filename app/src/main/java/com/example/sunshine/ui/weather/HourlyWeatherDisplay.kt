package com.example.sunshine.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sunshine.R
import com.example.sunshine.domain.weather.WeatherData
import com.example.sunshine.ui.model.WeatherType
import com.example.sunshine.ui.theme.SunshineTheme
import com.example.sunshine.ui.utils.formattedTime
import java.time.LocalDateTime

@Composable
fun HourlyWeatherDisplay(
    data: WeatherData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    val formattedTime = remember(data) {
        (data.time ?: LocalDateTime.now()).formattedTime
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = formattedTime,
            color = Color.LightGray
        )
        val weatherType = WeatherType.of(data.weatherCode)
        Image(
            painter = painterResource(id = weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = stringResource(
                id = R.string.format_temperature,
                data.temperatureCelsius ?: 0.0
            ),
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHourlyWeatherDisplay() {
    SunshineTheme {
        val item = WeatherData(
            time = LocalDateTime.now(),
            weatherCode = 0,
            pressure = 0.0,
            temperatureCelsius = 0.0,
            windSpeed = 0.0,
            humidity = 0,
        )
        HourlyWeatherDisplay(
            data = item,
            textColor = Color.DarkGray
        )
    }
}
