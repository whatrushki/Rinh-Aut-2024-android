package app.what.main.children.live.domain.models

sealed interface LiveEvent {
    data object Init : LiveEvent
}