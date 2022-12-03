package com.example.sunshine.ui.forecast

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.sunshine.R
import com.example.sunshine.domain.weather.WeatherData
import com.example.sunshine.ui.model.WeatherType
import com.example.sunshine.ui.utils.SunshineDateUtils

@Composable
fun ForecastItem(
    modifier: Modifier = Modifier,
    data: WeatherData,
    onItemSelected: (WeatherData) -> Unit,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .clickable { onItemSelected(data) },
    ) {
        val (icon, description, tempMax, tempMin) = createRefs()
        val weatherType = WeatherType.of(data.weatherCode)

        Image(
            painter = painterResource(id = weatherType.iconRes),
            modifier = Modifier
                .size(40.dp)
                .constrainAs(icon) {
                    start.linkTo(parent.start)
                },
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.accessibility_weather_icon),
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .constrainAs(description) {
                    start.linkTo(icon.end)
                }
        ) {
            val formattedDate = SunshineDateUtils.getFriendlyDateString(
                LocalContext.current,
                data.time,
                false,
            )
            Text(text = formattedDate, style = TextStyle(fontSize = 16.sp))
            Text(text = weatherType.weatherDesc, style = TextStyle(fontSize = 16.sp))
        }
        Text(
            modifier = Modifier
                .padding(end = 16.dp)
                .constrainAs(tempMax) {
                    end.linkTo(tempMin.start)
                },
            text = data.temperatureCelsius.toString(),
            style = TextStyle(fontSize = 28.sp),
        )
        Text(
            modifier = Modifier
                .constrainAs(tempMin) {
                    end.linkTo(parent.end)
                },
            text = data.temperatureCelsius.toString(),
            style = TextStyle(fontSize = 28.sp),
        )
    }
}
