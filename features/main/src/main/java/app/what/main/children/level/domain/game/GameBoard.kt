package app.what.main.children.level.domain.game

import app.what.main.children.level.domain.models.GameResult


data class GameBoard(
    val start: Point,
    val exits: Map<Point, LevelRef>,
    val hero: Hero,
    val grid: List<List<CellType>>,
    val collectedGems: List<CellType.Entity.Gem> = emptyList()
) {
    fun gameResult(): GameResult? = when {
        exits.containsKey(hero.position) -> GameResult.Finished
        hero.hp <= 0 -> GameResult.Defeated
        else -> null
    }

    fun printBoard(hero: Hero): String {
        var result = ""

        for ((y, row) in grid.withIndex()) {
            for ((x, cell) in row.withIndex()) {
                val ui = when {
                    hero.position.x == x && hero.position.y == y -> "H"
                    Point(x, y) in exits -> "II"
                    cell is CellType.Entity.Enemy && !cell.hidden && !cell.defeated -> "E"
                    cell is CellType.Entity.Gem && !cell.hidden && !cell.collected -> "*"
                    cell is CellType.Entity.Obstacle -> "#"
                    Point(x, y) == start -> "II"
                    else -> "."
                }
                result += "$ui "
            }
            result += "\n"
        }
        return result
    }

    fun moveHero(x: Int, y: Int): GameBoard {
        val newPos = Point(
            (hero.position.x + x).coerceIn(grid[0].indices),
            (hero.position.y + y).coerceIn(grid.indices)
        )

        if (newPos.x in grid[0].indices && newPos.y in grid.indices) {
            return when (val cell = grid[newPos.y][newPos.x]) {
                is CellType.Entity.Enemy -> {
                    cell.hidden = false
                    cell.hp -= hero.attack

                    if (cell.hp <= 0) return copy(
                        hero = hero.copy(position = newPos)
                    )

                    val remainder: Int

                    copy(
                        hero = hero.copy(
                            shield = (hero.shield - cell.attack)
                                .apply { remainder = this }
                                .coerceAtLeast(0),
                            hp = hero.hp + remainder.coerceAtMost(0)
                        )
                    )
                }

                is CellType.Entity.Gem -> {
                    cell.collected = true

                    return copy(
                        collectedGems = collectedGems + cell,
                        hero = hero.copy(position = newPos)
                    )
                }

                is CellType.Entity.Obstacle -> copy(
                    hero = hero.copy(hp = hero.hp - cell.damage)
                )

                else -> copy(hero = hero.copy(position = newPos))
            }
        }

        return copy()
    }
}