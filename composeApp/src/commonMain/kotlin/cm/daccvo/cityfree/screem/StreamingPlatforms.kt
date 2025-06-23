package cm.daccvo.cityfree.screem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StreamingPlatforms() {
    Row(
        modifier = Modifier.padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Spotify
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Placeholder for Spotify icon
            Surface(
                modifier = Modifier.size(24.dp),
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFF1DB954)
            ) {}
            Text(
                text = "Spotify",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // SoundCloud
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Placeholder for SoundCloud icon
            Surface(
                modifier = Modifier.size(24.dp),
                shape = RoundedCornerShape(4.dp),
                color = Color(0xFFFF5500)
            ) {}
            Text(
                text = "SOUNDCLOUD",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // iTunes
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Placeholder for iTunes icon
            Surface(
                modifier = Modifier.size(24.dp),
                shape = RoundedCornerShape(4.dp),
                color = Color.White
            ) {}
            Text(
                text = "iTunes",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}