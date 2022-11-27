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
import com.example.sunshine.presentation.model.ForecastView
import com.example.sunshine.ui.utils.SunshineDateUtils
import com.example.sunshine.ui.utils.SunshineWeatherUtils

private const val TIME_UNIT_MILLIS = 1_000L

@Composable
fun WeatherItem(
    modifier: Modifier = Modifier,
    forecast: ForecastView,
    isMetric: Boolean = true,
    onItemSelected: () -> Unit,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .clickable { onItemSelected() },
    ) {
        val (icon, description, tempMax, tempMin) = createRefs()

        val context = LocalContext.current
        val formattedTempMin =
            SunshineWeatherUtils.formatTemperature(context, forecast.tempMax, isMetric)
        val formattedTempMax =
            SunshineWeatherUtils.formatTemperature(context, forecast.tempMax, isMetric)

        Image(
            painter = painterResource(id = R.drawable.art_clouds),
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
                forecast.date * TIME_UNIT_MILLIS,
                false,
            )
            val formattedDescription = stringResource(
                id = SunshineWeatherUtils.getStringIdForWeatherCondition(forecast.icon)
            )
            Text(text = formattedDate, style = TextStyle(fontSize = 16.sp))
            Text(text = formattedDescription, style = TextStyle(fontSize = 16.sp))
        }
        Text(
            modifier = Modifier
                .padding(end = 16.dp)
                .constrainAs(tempMax) {
                    end.linkTo(tempMin.start)
                },
            text = formattedTempMax,
            style = TextStyle(fontSize = 28.sp),
        )
        Text(
            modifier = Modifier
                .constrainAs(tempMin) {
                    end.linkTo(parent.end)
                },
            text = formattedTempMin,
            style = TextStyle(fontSize = 28.sp),
        )
    }
}
