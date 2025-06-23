package cm.daccvo.cityfree.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIScreen

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun getScreenWidth(): Dp {
    val screenWidth = UIScreen.mainScreen.bounds.useContents { size.width }
    return (screenWidth * UIScreen.mainScreen.scale).dp
}