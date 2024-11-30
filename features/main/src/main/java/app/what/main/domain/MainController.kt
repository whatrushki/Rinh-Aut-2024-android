package app.what.main.domain

import app.what.foundation.core.UIController
import app.what.main.domain.models.MainAction
import app.what.main.domain.models.MainEvent
import app.what.main.domain.models.MainState

class MainController : UIController<MainState, MainAction, MainEvent>(
    MainState()
) {
    override fun obtainEvent(viewEvent: MainEvent) = when (viewEvent) {
        MainEvent.Init -> {}
        else -> {}
    }
}