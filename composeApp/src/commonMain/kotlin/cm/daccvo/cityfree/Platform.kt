package cm.daccvo.cityfree

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform