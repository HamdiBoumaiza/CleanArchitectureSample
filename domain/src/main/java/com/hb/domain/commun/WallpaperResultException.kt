package com.hb.domain.commun

sealed class WallpaperResultException(
    val messageResource: Int
) : RuntimeException("") {

    class Connection(messageResource: Int) : WallpaperResultException(messageResource)

    class Unexpected(messageResource: Int) : WallpaperResultException(messageResource)

    class Timeout(messageResource: Int) : WallpaperResultException(messageResource)

    class Client(messageResource: Int) : WallpaperResultException(messageResource)

    class Server(messageResource: Int) : WallpaperResultException(messageResource)

}