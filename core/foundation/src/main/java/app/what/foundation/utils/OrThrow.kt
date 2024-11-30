package app.what.foundation.utils


inline val <reified T : Any?> T.orThrow
    get() = this ?: throw NullPointerException("${T::class} is null")
