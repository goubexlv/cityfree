package cm.daccvo.cityfree.screem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope

@Composable
fun BackgroundImage() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        // Gradient background
        val gradient = Brush.radialGradient(
            colors = listOf(
                Color(0xFF8B0000), // Dark red
                Color(0xFF2B0000), // Very dark red
                Color.Black
            ),
            center = Offset(size.width * 0.7f, size.height * 0.3f),
            radius = size.width * 0.8f
        )

        drawRect(
            brush = gradient,
            size = size
        )

        // Simulate DJ silhouette (simplified)
        drawCircle(
            color = Color(0xFF4A0000),
            radius = size.width * 0.15f,
            center = Offset(size.width * 0.75f, size.height * 0.4f)
        )

        // Headphones representation
        drawCircle(
            color = Color(0xFF6A0000),
            radius = size.width * 0.08f,
            center = Offset(size.width * 0.72f, size.height * 0.35f)
        )

        drawCircle(
            color = Color(0xFF6A0000),
            radius = size.width * 0.08f,
            center = Offset(size.width * 0.78f, size.height * 0.35f)
        )
    }
}