package com.owlite.socialexit.core.common.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val seDispatcher: SeDispatchers)

enum class SeDispatchers {
    Default,
    IO
}
