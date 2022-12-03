package com.example.sunshine.ui.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sunshine.R
import com.example.sunshine.domain.weather.WeatherData
import com.example.sunshine.ui.theme.SunshineTheme
import com.example.sunshine.ui.utils.formattedDay
import java.time.LocalDate
import java.time.LocalDateTime

@Composable
fun WeatherForecast(
    data: List<WeatherData>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val today = LocalDate.now()
        val text = when (val date = data.first().time?.toLocalDate() ?: today) {
            today -> stringResource(id = R.string.today)
            today.plusDays(1) -> stringResource(id = R.string.tomorrow)
            else -> date.formattedDay
        }

        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(content = {
            items(data) { weatherData ->
                HourlyWeatherDisplay(
                    data = weatherData,
                    modifier = Modifier
                        .height(100.dp)
                        .padding(horizontal = 16.dp)
                )
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherForecast() {
    SunshineTheme {
        val item = WeatherData(
            time = LocalDateTime.now(),
            weatherCode = 0,
            pressure = 0.0,
            temperatureCelsius = 0.0,
            windSpeed = 0.0,
            humidity = 0,
        )
        val data = listOf(
            item.copy(time = item.time?.minusHours(1)),
            item.copy(time = item.time),
            item.copy(time = item.time?.plusHours(1)),
        )
        WeatherForecast(
            data = data,
        )
    }
}
