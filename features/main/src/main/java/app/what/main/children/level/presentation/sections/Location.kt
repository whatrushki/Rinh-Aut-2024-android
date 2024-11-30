package app.what.main.children.level.presentation.sections

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import app.what.foundation.core.Listener
import app.what.main.children.level.domain.models.GameResult
import app.what.main.children.level.domain.models.LevelEvent
import app.what.main.children.level.domain.models.LevelState


@Composable
fun GameContent(
    modifier: Modifier = Modifier,
    state: LevelState,
    listener: Listener<LevelEvent>
) {
    val contentColorTarget = when {
        state.isSimulationRunning -> MaterialTheme.colorScheme.onSecondary
        state.gameResult == GameResult.Defeated -> MaterialTheme.colorScheme.onError
        state.gameResult != null -> MaterialTheme.colorScheme.onPrimary
        else -> MaterialTheme.colorScheme.onSecondary
    }

    val contentColor by animateColorAsState(
        targetValue = contentColorTarget,
        label = "contentColor"
    )

    Column(modifier = modifier) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                when (state.gameResult) {
                    null -> Unit

                    GameResult.Defeated -> Text(
                        text = "Поражение",
                        style = MaterialTheme.typography.headlineMedium,
                        color = contentColor,
                    )

                    GameResult.Finished -> Text(
                        text = "Победа",
                        style = MaterialTheme.typography.headlineMedium,
                        color = contentColor,
                    )
                }


                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(4.dp)
                        .clip(MaterialTheme.shapes.large)
                        .background(contentColor)
                ) { GridForGame(state, listener) }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Counter(state.board.hero.hp, color = contentColor)

                LinearProgressIndicator(
                    progress = { state.board.hero.hp / 10f },
                    strokeCap = StrokeCap.Round,
                    color = Color.Red
                )

//                Text(
//                    modifier = Modifier.weight(1f),
//                    text = "${state.board.hero.hp}/100",
//                    color = contentColor,
//                    overflow = TextOverflow.Clip,
//                    maxLines = 1
//                )
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Counter(state.board.hero.shield, color = contentColor)

                LinearProgressIndicator(
                    progress = { state.board.hero.shield / 10f },
                    strokeCap = StrokeCap.Round,
                    color = Color.Blue
                )
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Counter(state.board.hero.attack, color = contentColor)

                LinearProgressIndicator(
                    progress = { state.board.hero.attack / 10f },
                    strokeCap = StrokeCap.Round,
                    color = Color.Yellow
                )
            }
        }
    }
}