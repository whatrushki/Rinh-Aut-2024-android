package app.what.main.children.level.domain.game

import app.what.main.children.level.domain.models.GameStyle

fun gameBoard(builder: GameBoardBuilder.() -> Unit) = GameBoardBuilder()
    .apply(builder)
    .build()

class GameBoardBuilder {
    private var width: Int = 0
    private var height: Int = 0
    private var start: Point = Point(0, 0)
    private var hero: Hero? = null
    private var maxCommandsCount: Int = 100
    private var style: GameStyle = GameStyle.Default
    private val entities = mutableMapOf<Point, CellType.Entity>()
    private val exits = mutableMapOf<Point, LevelRef>()
    private var hint = ""
    private var availableCommandsByBoardManager: (CommandBoardManager) -> List<Command<*>> =
        { emptyList() }

    fun size(all: Int) {
        width = all
        height = all
    }

    fun style(value: GameStyle) {
        style = value
    }

    fun hint(value: String) {
        hint = value
    }

    fun size(height: Int, width: Int) {
        this.width = width
        this.height = height
    }

    fun commands(maxCount: Int = 0, commandsBuilder: (CommandBoardManager) -> List<Command<*>>) {
        this.maxCommandsCount = maxCount
        this.availableCommandsByBoardManager = commandsBuilder
    }

    fun hero(attack: Int, hp: Int, shield: Int = 0) {
        hero = Hero(attack, hp, shield, start)
    }

    fun start(x: Int, y: Int) {
        start = Point(x, y)
    }

    fun exits(builder: MutableMap<Point, LevelRef>.() -> Unit) = exits.apply(builder)
    fun enemy(point: Point, attack: Int, hp: Int, hidden: Boolean = false) {
        entities[point] = CellType.Entity.Enemy(attack, hp, hidden, point)
    }

    fun obstacle(point: Point, damage: Int) {
        entities[point] = CellType.Entity.Obstacle(damage, point)
    }

    fun gem(point: Point, secret: Boolean = false) {
        entities[point] = CellType.Entity.Gem(secret, point, false)
    }

    fun build(): GameBoard {
        val grid = MutableList(height) { MutableList<CellType>(width) { CellType.Empty } }
        entities.forEach { (point, entity) ->
            grid[point.y][point.x] = entity
        }

        val hero = hero ?: error("Hero must be specified")

        return GameBoard(
            start = start,
            exits = exits,
            hero = hero,
            grid = grid,
            availableCommandsBuilder = availableCommandsByBoardManager,
            maxCommandsCount = maxCommandsCount,
            style = style
        )
    }
}