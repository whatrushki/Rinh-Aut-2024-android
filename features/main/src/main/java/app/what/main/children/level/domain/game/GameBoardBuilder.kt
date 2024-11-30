package app.what.main.children.level.domain.game

fun gameBoard(builder: GameBoardBuilder.() -> Unit) = GameBoardBuilder()
    .apply(builder)
    .build()

class GameBoardBuilder {
    private var width: Int = 0
    private var height: Int = 0
    private var start: Point = Point(0, 0)
    private var hero: Hero? = null
    private val entities = mutableMapOf<Point, CellType.Entity>()
    private val exits = mutableMapOf<Point, LevelRef>()

    fun size(all: Int) {
        width = all
        height = all
    }

    fun size(height: Int, width: Int) {
        this.width = width
        this.height = height
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

        val heroPair = hero ?: error("Hero must be specified")

        return GameBoard(start, exits, heroPair, grid)
    }
}