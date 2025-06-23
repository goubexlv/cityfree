package cm.daccvo.cityfree.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSizeClass {
    COMPACT,    // Mobile: < 600dp
    MEDIUM,     // Tablet: 600-840dp
    EXPANDED    // Desktop/Web: > 840dp
}

// Fonction expect/actual pour obtenir la largeur d'écran
@Composable
expect fun getScreenWidth(): Dp

@Composable
fun getWindowSizeClass(): WindowSizeClass {
    val screenWidth = getScreenWidth()

    return when {
        screenWidth < 600.dp -> WindowSizeClass.COMPACT
        screenWidth < 840.dp -> WindowSizeClass.MEDIUM
        else -> WindowSizeClass.EXPANDED
    }
}