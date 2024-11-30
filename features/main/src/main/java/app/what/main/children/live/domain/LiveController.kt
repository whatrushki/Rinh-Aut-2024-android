package app.what.main.children.live.domain

import app.what.foundation.core.UIController
import app.what.main.children.live.domain.models.LiveAction
import app.what.main.children.live.domain.models.LiveEvent
import app.what.main.children.live.domain.models.LiveState

class LiveController : UIController<LiveState, LiveAction, LiveEvent>(
    LiveState()
) {
    override fun obtainEvent(viewEvent: LiveEvent) = when (viewEvent) {
        LiveEvent.Init -> {}
        else -> {}
    }

    fun init() {}

}