package cm.daccvo.cityfree.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

@Composable
actual fun getScreenWidth(): Dp {
    return window.innerWidth.dp
}