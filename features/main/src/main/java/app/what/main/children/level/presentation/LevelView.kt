package app.what.main.children.level.presentation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import app.what.foundation.core.Listener
import app.what.main.children.level.domain.models.GameResult
import app.what.main.children.level.domain.models.LevelEvent
import app.what.main.children.level.domain.models.LevelState
import app.what.main.children.level.presentation.sections.GameContent
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LevelView(
    state: LevelState,
    listener: Listener<LevelEvent>
) {
    val containerColorTarget = when (state.gameResult) {
        GameResult.Defeated -> MaterialTheme.colorScheme.error
        GameResult.Finished -> Color.Green
        else -> MaterialTheme.colorScheme.secondary
    }

    val containerColor by animateColorAsState(
        targetValue = containerColorTarget,
        label = "containerColor"
    )

    val contentColorTarget = when (state.gameResult) {
        GameResult.Defeated -> MaterialTheme.colorScheme.onError
        GameResult.Finished -> Color.Black
        else -> MaterialTheme.colorScheme.onSecondary
    }

    val contentColor by animateColorAsState(
        targetValue = contentColorTarget,
        label = "contentColor"
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(containerColor)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .systemBarsPadding()

        ) {
            var pinned by rememberSaveable { mutableStateOf(false) }

            val collapsingToolbarScaffold = rememberCollapsingToolbarScaffoldState()

            CollapsingToolbarScaffold(
                modifier = Modifier.fillMaxSize(),
                state = collapsingToolbarScaffold,
                scrollStrategy = ScrollStrategy.EnterAlways,
                toolbar = {

                },
            ) {
                LazyColumn(
                    modifier = Modifier.background(MaterialTheme.colorScheme.surface)
                ) {
                    if (pinned) {
                        stickyHeader {
                            GameContent(
                                state = state,
                                listener = listener,
                                modifier = Modifier
                                    .clip(
                                        MaterialTheme.shapes.large.copy(
                                            topStart = ZeroCornerSize,
                                            topEnd = ZeroCornerSize
                                        )
                                    )
                                    .background(containerColor)
                            )
                        }
                    } else {
                        item {
                            GameContent(
                                state = state,
                                listener = listener,
                                modifier = Modifier
                                    .clip(
                                        MaterialTheme.shapes.large.copy(
                                            topStart = ZeroCornerSize,
                                            topEnd = ZeroCornerSize
                                        )
                                    )
                                    .background(containerColor)
                            )
                        }
                    }

                    item {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Button(
                                enabled = state.gameResult == null,
                                onClick = { listener(LevelEvent.MoveUp) }
                            ) { Text("Вверх") }
                            Row {
                                Button(
                                    enabled = state.gameResult == null,
                                    onClick = { listener(LevelEvent.MoveLeft) }
                                ) { Text("Влево") }
                                Button(
                                    enabled = state.gameResult == null,
                                    onClick = { listener(LevelEvent.MoveRight) }
                                ) { Text("Вправо") }
                            }
                            Button(
                                enabled = state.gameResult == null,
                                onClick = { listener(LevelEvent.MoveDown) }
                            ) { Text("Вниз") }
                        }
                    }
                }
            }
        }
    }
}