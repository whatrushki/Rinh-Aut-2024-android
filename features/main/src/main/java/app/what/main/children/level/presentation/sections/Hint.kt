package app.what.main.children.level.presentation.sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.what.foundation.services.LocalSheetProvider
import app.what.main.children.level.domain.game.GameBoard

fun hint(board: GameBoard) = @Composable {
    Box(
        Modifier.padding(2.dp)
    ) {
        Text(board.hint)
    }
}