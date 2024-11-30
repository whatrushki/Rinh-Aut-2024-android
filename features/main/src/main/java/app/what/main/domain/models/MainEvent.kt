package app.what.main.domain.models

sealed interface MainEvent {
    data object Init : MainEvent
}