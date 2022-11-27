package com.example.sunshine.ui.forecast

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sunshine.ui.forecast.ForecastViewModel.*
import com.example.sunshine.ui.theme.SunshineTheme

@Composable
fun ForecastViewComposable(viewModel: ForecastViewModel) {
    val state by viewModel.state.collectAsState()

    ForecastView(state = state)
}

@Composable
fun ForecastView(state: ViewState) {
    when (state) {
        ViewState.Loading -> LoadingScreen()
        is ViewState.Success -> Text(text = "${state.forecast}")
        is ViewState.Error -> Text(text = "${state.exception}")
    }

}

@Composable
private fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SunshineTheme {
        ForecastView(state = ViewState.Loading)
    }
}