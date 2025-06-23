package cm.daccvo.cityfree.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cm.daccvo.cityfree.screem.BackgroundImage
import cm.daccvo.cityfree.screem.HeroSection
import cm.daccvo.cityfree.ui.utils.WindowSizeClass
import cm.daccvo.cityfree.ui.utils.getWindowSizeClass

data class NavigationItem(
    val title: String,
    val icon: String, // Emoji ou caractère pour l'icône
    val isActive: Boolean = false,
    val onClick: () -> Unit = {}
)

@Composable
fun ResponsiveNavigationBar(
    modifier: Modifier = Modifier,
    selectedTab: String = "MUSIC",
    onNavigate: (String) -> Unit = {}
) {
    val windowSizeClass = getWindowSizeClass()

    val navigationItems = remember(selectedTab) {
        listOf(
            NavigationItem(
                title = "MUSIC",
                icon = "🎵",
                isActive = selectedTab == "MUSIC"
            ) { onNavigate("MUSIC") },
            NavigationItem(
                title = "EVENTS",
                icon = "🎤",
                isActive = selectedTab == "EVENTS"
            ) { onNavigate("EVENTS") },
            NavigationItem(
                title = "VIDEOS",
                icon = "📹",
                isActive = selectedTab == "VIDEOS"
            ) { onNavigate("VIDEOS") },
            NavigationItem(
                title = "BIO",
                icon = "👨‍🎤",
                isActive = selectedTab == "BIO"
            ) { onNavigate("BIO") },
            NavigationItem(
                title = "PRESS",
                icon = "📰",
                isActive = selectedTab == "PRESS"
            ) { onNavigate("PRESS") },
            NavigationItem(
                title = "ELEMENTS",
                icon = "🎨",
                isActive = selectedTab == "ELEMENTS"
            ) { onNavigate("ELEMENTS") }
        )
    }

    when (windowSizeClass) {
        WindowSizeClass.COMPACT -> {
            InstagramStyleMobileNav(
                modifier = modifier,
                items = navigationItems
            )
        }
        WindowSizeClass.MEDIUM -> {
            TabletNavigationBar(
                modifier = modifier,
                items = navigationItems
            )
        }
        WindowSizeClass.EXPANDED -> {
            DesktopNavigationBar(
                modifier = modifier,
                items = navigationItems
            )
        }
    }
}

@Composable
private fun InstagramStyleMobileNav(
    modifier: Modifier = Modifier,
    items: List<NavigationItem>
) {
    // Header simple avec logo
    Column(modifier = modifier) {
        // Top header minimaliste
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "DJ BEAT$",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom navigation bar (Instagram style)
        BottomNavigationBar(items = items)
    }
}

@Composable
private fun BottomNavigationBar(
    items: List<NavigationItem>
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.Black.copy(alpha = 0.95f),
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                BottomNavItem(
                    item = item,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun BottomNavItem(
    item: NavigationItem,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val scale by animateFloatAsState(
        targetValue = if (item.isActive) 1.2f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scale"
    )

    val alpha by animateFloatAsState(
        targetValue = if (item.isActive) 1f else 0.6f,
        animationSpec = tween(200),
        label = "alpha"
    )

    Column(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { item.onClick() }
            .padding(vertical = 8.dp)
            .scale(scale),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Icône avec animation
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(
                    if (item.isActive)
                        Color.White.copy(alpha = 0.1f)
                    else
                        Color.Transparent
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = item.icon,
                fontSize = 18.sp,
                modifier = Modifier.alpha(alpha)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Label avec animation
        Text(
            text = item.title,
            color = Color.White.copy(alpha = alpha),
            fontSize = 10.sp,
            fontWeight = if (item.isActive) FontWeight.Bold else FontWeight.Medium,
            maxLines = 1,
            textAlign = TextAlign.Center
        )

        // Indicateur actif (petit point)
        AnimatedVisibility(
            visible = item.isActive,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 2.dp)
                    .size(4.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
        }
    }
}

@Composable
private fun TabletNavigationBar(
    modifier: Modifier = Modifier,
    items: List<NavigationItem>
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) {
        items(items) { item ->
            TabletNavItem(item = item)
        }
    }
}

@Composable
private fun TabletNavItem(item: NavigationItem) {
    val scale by animateFloatAsState(
        targetValue = if (item.isActive) 1.1f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "scale"
    )

    Row(
        modifier = Modifier
            .clickable { item.onClick() }
            .scale(scale)
            .clip(RoundedCornerShape(16.dp))
            .background(
                if (item.isActive)
                    Color.White.copy(alpha = 0.1f)
                else
                    Color.Transparent
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = item.icon,
            fontSize = 16.sp
        )

        Text(
            text = item.title,
            color = if (item.isActive) Color.White else Color.White.copy(alpha = 0.7f),
            fontSize = 14.sp,
            fontWeight = if (item.isActive) FontWeight.Bold else FontWeight.Medium
        )
    }
}

@Composable
private fun DesktopNavigationBar(
    modifier: Modifier = Modifier,
    items: List<NavigationItem>
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        items.forEach { item ->
            DesktopNavItem(item = item)
        }
    }
}

@Composable
private fun DesktopNavItem(item: NavigationItem) {
    val scale by animateFloatAsState(
        targetValue = if (item.isActive) 1.05f else 1f,
        animationSpec = tween(200),
        label = "scale"
    )

    Text(
        text = item.title,
        color = if (item.isActive) Color.White else Color.White.copy(alpha = 0.8f),
        fontSize = 14.sp,
        fontWeight = if (item.isActive) FontWeight.Bold else FontWeight.Medium,
        modifier = Modifier
            .clickable { item.onClick() }
            .scale(scale)
            .padding(horizontal = 20.dp, vertical = 8.dp)
    )
}

// Usage dans MainScreen avec gestion d'état
@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf("MUSIC") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background
        BackgroundImage()

        // Content
        ResponsiveNavigationBar(
            selectedTab = selectedTab,
            onNavigate = { tab ->
                selectedTab = tab
                // Handle navigation logic
            }
        )

        // Main content based on selected tab
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = if (getWindowSizeClass() == WindowSizeClass.COMPACT) 80.dp else 0.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            when (selectedTab) {
                "MUSIC" -> HeroSection()
                "EVENTS" -> EventsContent()
                "VIDEOS" -> VideosContent()
                "BIO" -> BioContent()
                "PRESS" -> PressContent()
                "ELEMENTS" -> ElementsContent()
            }
        }
    }
}

// Contenus d'exemple pour chaque section
@Composable
private fun EventsContent() {
    Text(
        text = "EVENTS SECTION",
        color = Color.White,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun VideosContent() {
    Text(
        text = "VIDEOS SECTION",
        color = Color.White,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun BioContent() {
    Text(
        text = "BIO SECTION",
        color = Color.White,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun PressContent() {
    Text(
        text = "PRESS SECTION",
        color = Color.White,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ElementsContent() {
    Text(
        text = "ELEMENTS SECTION",
        color = Color.White,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}