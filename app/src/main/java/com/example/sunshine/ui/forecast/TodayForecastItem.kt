package com.example.sunshine.ui.forecast

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.sunshine.R
import com.example.sunshine.domain.weather.WeatherData
import com.example.sunshine.ui.model.WeatherType
import com.example.sunshine.ui.theme.SunshineTheme
import com.example.sunshine.ui.utils.SunshineDateUtils
import java.time.LocalDateTime

@Composable
fun TodayWeatherItem(
    modifier: Modifier = Modifier,
    data: WeatherData,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),
    ) {
        val (date, icon, tempMin, tempMax, description) = createRefs()
        val weatherType = WeatherType.of(data.weatherCode)
        val formattedDate = SunshineDateUtils.getFriendlyDateString(
            context = LocalContext.current,
            date = data.time,
            isFirst = true,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .constrainAs(date) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = formattedDate,
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            ),
        )
        Image(
            modifier = Modifier
                .size(120.dp)
                .padding(top = 16.dp, start = 40.dp)
                .constrainAs(icon) {
                    top.linkTo(date.bottom)
                    start.linkTo(parent.start)
                },
            painter = painterResource(id = weatherType.iconRes),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.accessibility_weather_icon),
        )
        Text(
            modifier = Modifier
                .padding(end = 40.dp)
                .constrainAs(tempMax) {
                    top.linkTo(icon.top)
                    bottom.linkTo(icon.bottom)
                    end.linkTo(parent.end)
                },
            text = data.temperatureCelsius.toString(),
            style = TextStyle(
                color = Color.White,
                fontSize = 72.sp,
                textAlign = TextAlign.Center,
            )
        )
        Text(
            modifier = Modifier
                .padding(end = 40.dp, bottom = 20.dp)
                .constrainAs(tempMin) {
                    top.linkTo(icon.bottom)
                    end.linkTo(tempMax.end)
                    start.linkTo(tempMax.start)
                },
            text = data.temperatureCelsius.toString(),
            style = TextStyle(
                color = Color.White,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
            ),
        )
        Text(
            modifier = Modifier
                .padding(start = 40.dp, bottom = 20.dp)
                .constrainAs(description) {
                    top.linkTo(tempMin.top)
                    bottom.linkTo(tempMin.bottom)
                    start.linkTo(icon.start)
                },
            text = weatherType.weatherDesc,
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodayWeatherItem() {
    val data = WeatherData(
        time = LocalDateTime.now(),
        temperatureCelsius = 0.0,
        pressure = 0.0,
        humidity = 0,
        windSpeed = 0.0,
        weatherCode = 0,
    )
    SunshineTheme {
        TodayWeatherItem(
            data = data
        )
    }
}
