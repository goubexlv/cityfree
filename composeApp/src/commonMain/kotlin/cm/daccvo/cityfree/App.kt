package cm.daccvo.cityfree

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cm.daccvo.cityfree.screem.MainScreen
import cm.daccvo.cityfree.screem.ScreenSize
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun App() {
    // Simuler une taille d'écran typique
    val simulatedScreenSize = ScreenSize(
        widthDp = 360,
        heightDp = 640
    )

    MaterialTheme{
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            MainScreen(screenSize = simulatedScreenSize)
        }
    }
}



