package cm.daccvo.cityfree.screem

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cm.daccvo.cityfree.ui.components.ResponsiveNavigationBar


data class ScreenSize(
    val widthDp: Int,
    val heightDp: Int
)

@Composable
fun MainScreen(screenSize: ScreenSize) {
    val width = screenSize.widthDp.dp
    val height = screenSize.heightDp.dp

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundImage()

        Column(modifier = Modifier.fillMaxSize()) {
            ResponsiveNavigationBar { destination ->
                println("Navigate to: $destination")
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = width * 0.05f),
                contentAlignment = Alignment.CenterStart
            ) {
                HeroSection(width = width, height = height)
            }
        }
    }
}

