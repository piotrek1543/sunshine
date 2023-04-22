package com.example.sunshine.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sunshine.R
import com.example.sunshine.domain.weather.WeatherData
import com.example.sunshine.ui.model.WeatherCodes
import com.example.sunshine.ui.model.WeatherDecoder
import com.example.sunshine.ui.theme.SunshineTheme
import com.example.sunshine.ui.utils.formattedTime
import com.example.sunshine.ui.utils.isNight
import java.time.LocalDateTime
import kotlin.math.roundToInt

@Composable
fun CurrentWeatherInfo(
    modifier: Modifier = Modifier,
    currentData: WeatherData,
) {
    val time = currentData.time
    val isNight = currentData.time?.isNight == true
    val weatherCode = currentData.weatherCode ?: WeatherCodes.UNKNOWN

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val backgroundRes = WeatherDecoder.getBackgroundsRes(weatherCode, isNight)
        Image(
            modifier = Modifier.matchParentSize(),
            painter = painterResource(id = backgroundRes),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(128.dp))
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(end = 16.dp, start = 16.dp, top = 72.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val today = stringResource(id = R.string.today, isNight)
            Text(
                text = "$today ${time?.formattedTime}",
                modifier = Modifier.align(Alignment.End),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))

            val iconRes = WeatherDecoder.getIconRes(weatherCode, isNight)
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.width(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(
                    id = R.string.format_temperature,
                    currentData.temperatureCelsius ?: 0.0
                ),
                fontSize = 50.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            val descriptionRes = WeatherDecoder.getStringRes(weatherCode)
            Text(
                text = stringResource(id = descriptionRes),
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(32.dp))
            WeatherDataDisplay(
                value = currentData.pressure?.roundToInt(),
                unit = "hpa",
                icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                iconTint = Color.White,
                textStyle = TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.height(16.dp))
            WeatherDataDisplay(
                value = currentData.windSpeed?.toInt(),
                unit = "km/h",
                icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                iconTint = Color.White,
                textStyle = TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.height(16.dp))
            WeatherDataDisplay(
                value = currentData.humidity,
                unit = "%",
                icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                iconTint = Color.White,
                textStyle = TextStyle(color = Color.White)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherCard() {
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
        CurrentWeatherInfo(
            currentData = data,
        )
    }
}
