package com.example.sunshine.ui.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationPermissionRequestView(
    locationPermissionsState: MultiplePermissionsState,
    onClick: () -> Unit
) {
    Column {
        val allPermissionsRevoked =
            locationPermissionsState.permissions.size ==
                locationPermissionsState.revokedPermissions.size

        val textToShow = if (!allPermissionsRevoked) {
            // If not all the permissions are revoked, it's because the user accepted the COARSE
            // location permission, but not the FINE one.
            "Yay! Thanks for letting me access your approximate location. " +
                "But you know what would be great? If you allow me to know where you " +
                "exactly are. Thank you!"
        } else if (locationPermissionsState.shouldShowRationale) {
            // Both location permissions have been denied
            "Getting your exact location is important for this app. " +
                "Please grant us fine location. Thank you :D"
        } else {
            // First time the user sees this feature or the user doesn't want to be asked again
            "This feature requires location permission"
        }

        val buttonText = if (!allPermissionsRevoked) {
            "Allow precise location"
        } else {
            "Request permissions"
        }

        Text(text = textToShow)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onClick) {
            Text(buttonText)
        }
    }
}