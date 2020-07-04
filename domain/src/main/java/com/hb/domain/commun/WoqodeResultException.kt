package com.hb.domain.commun

sealed class WoqodeResultException(
    val messageResource: Int
) : RuntimeException("") {

    class Connection(messageResource: Int) : WoqodeResultException(messageResource)

    class Unexpected(messageResource: Int) : WoqodeResultException(messageResource)

    class Timeout(messageResource: Int) : WoqodeResultException(messageResource)

    class Client(messageResource: Int) : WoqodeResultException(messageResource)

    class Server(messageResource: Int) : WoqodeResultException(messageResource)

}