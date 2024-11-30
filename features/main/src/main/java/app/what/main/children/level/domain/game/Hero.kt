package app.what.main.children.level.domain.game

data class Hero(var attack: Int, var hp: Int, var shield: Int, var position: Point) {
    val defeated
        get() = hp <= 0
}