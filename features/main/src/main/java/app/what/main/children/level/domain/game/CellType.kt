package app.what.main.children.level.domain.game

sealed interface CellType {
    data object Empty : CellType
    sealed class Entity(open val hidden: Boolean = false) : CellType {
        data class Enemy(
            var attack: Int,
            var hp: Int,
            override var hidden: Boolean,
            val position: Point
        ) : Entity() {
            val defeated
                get() = hp <= 0
        }

        data class Obstacle(val damage: Int, val position: Point) : Entity()
        data class Gem(
            override val hidden: Boolean,
            val position: Point,
            var collected: Boolean
        ) : Entity()
    }
}