package com.hb.domain.commun

sealed class WoqodeResultException(
    errorMessage: String
) : RuntimeException(errorMessage) {

    class Connection(messageResource: String) : WoqodeResultException(messageResource)

    class Unexpected(messageResource: String) : WoqodeResultException(messageResource)

    class Timeout(messageResource: String) : WoqodeResultException(messageResource)

    class Client(messageResource: String) : WoqodeResultException(messageResource)

    class Server(messageResource: String) : WoqodeResultException(messageResource)

}