package app.what.main.children.live.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.what.foundation.core.Listener
import app.what.main.children.live.domain.models.LiveEvent
import app.what.main.children.live.domain.models.LiveState

@Composable
fun LiveView(
    state: LiveState,
    listener: Listener<LiveEvent>
) = Column(
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
) {
}