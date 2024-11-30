package app.what.foundation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun <T : Any?> useState(initialValue: T): MutableState<T> {
    val state = remember { mutableStateOf(initialValue) }
    return state
}