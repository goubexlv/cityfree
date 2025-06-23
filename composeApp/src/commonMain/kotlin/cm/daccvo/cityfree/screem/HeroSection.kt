package cm.daccvo.cityfree.screem

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 60.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        // Main Title
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Text(
                text = "DJ BEAT$",
                color = Color.White,
                fontSize = 72.sp,
                fontWeight = FontWeight.Black,
                lineHeight = 72.sp
            )
            Text(
                text = "MUSIC",
                color = Color.White,
                fontSize = 72.sp,
                fontWeight = FontWeight.Black,
                lineHeight = 72.sp
            )
            Text(
                text = "PRODUCER",
                color = Color.White,
                fontSize = 72.sp,
                fontWeight = FontWeight.Black,
                lineHeight = 72.sp
            )
        }

        // Streaming Platforms
        StreamingPlatforms()

        // Listen Playlist Button
        Button(
            onClick = { /* Handle playlist action */ },
            modifier = Modifier
                .padding(top = 20.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(
                text = "LISTEN PLAYLIST",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 1.sp
            )
        }
    }
}


@Composable
fun HeroSection(
    width: Dp,
    height: Dp
) {
    Column(
        modifier = Modifier
            .widthIn(max = width * 0.9f) // Par exemple, 90% de la largeur
            .heightIn(max = height * 0.6f)
            .padding(16.dp)
    ) {
        Text(
            text = "Bienvenue chez CityFree",
            fontSize = if (width < 600.dp) 20.sp else 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Votre plateforme de services connectés",
            fontSize = if (width < 600.dp) 14.sp else 20.sp,
            color = Color.White
        )
        // Ajoute plus de contenu ici
    }
}
