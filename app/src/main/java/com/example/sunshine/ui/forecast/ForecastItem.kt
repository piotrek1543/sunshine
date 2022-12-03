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
        val (icon, description, temperature) = createRefs()
        val weatherType = WeatherType.of(data.weatherCode)

        Image(
            painter = painterResource(id = weatherType.iconRes),
            modifier = Modifier
                .size(40.dp)
                .constrainAs(icon) {
                    start.linkTo(parent.start)
                },
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
                .constrainAs(temperature) {
                    end.linkTo(parent.end)
                },
            text = stringResource(id = R.string.format_temperature, data.temperatureCelsius ?: 0.0),
            style = TextStyle(fontSize = 28.sp),
        )
    }
}
