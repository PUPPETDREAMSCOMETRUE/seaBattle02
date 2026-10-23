class Player(val name: String) {
    private val _field: Array<Array<CellState>> =
        Array(10) { Array(10) { CellState.EMPTY} }
    fun field(): Array<Array<CellState>> = _field
    var shipsLeft: Int = 20
    var field: Array<CharArray> = Array(10) {
        CharArray(10) { '.'}
    }
    private var _shots: Int = 0
    private var _hits: Int = 0
    val shots: Int
        get() = _shots
    val hits: Int
        get() = _hits
    fun printField(showShips: Boolean = true, debug: Boolean = false) {
        println(" ===    $name    ===")
        val size = field.size
        if (debug) {
            print("      ")
            for (c in 0 until size) print("$c   ")
            println()
            fun printBorder() {
                print("   +")
                for (c in 0 until size) {
                    print("---+")
                }
                println()
            }
            for (r in 0 until size) {
                printBorder()
                print(" $r |")
                for (c in 0 until size) {
                    val cell = field[r][c]
                    val displayCell = if (!showShips && cell == '#') '.' else cell
                    print(" $displayCell |")
                }
                println()
            }
            printBorder()
        }
        else{
            print("   ")
            for (c in 0 until field[0].size) {
                print("$c ")
            }
            println()
            for (r in 0 until field.size) {
                print("$r  ")
                for (c in 0 until field[r].size) {
                    val cell = field[r][c]
                    if (!showShips && cell == '#') {
                        print(". ")
                    } else {
                        print("$cell ")
                    }
                }
                println()
            }
        }
    }
    fun isAlive(): Boolean {
        if (shipsLeft > 0) {
            return true
        }
        else {
            return false
        }
    }
    fun accuracy(): Double {
        if (_shots == 0) {
            return 0.0
        }
        return _hits *  100.0 / _shots
    }
    fun takeDamage(): Boolean {
        shipsLeft--
        if (isAlive()) {return true}
        else {return false}
    }
    fun registerShot(hit: Boolean) {_shots++
    if (hit) {_hits++} }
    fun reset() {
        _shots = 0
        _hits = 0
        for (r in 0 until field.size) {
            for (c in 0 until field[r].size) {
                _field[r][c] = CellState.EMPTY
            }
        }
    }
    fun printStatus(): String {
        val currentAccuracy = String.format("%.1f", accuracy())
        return("Игрок $name: палуб осталось $shipsLeft, выстрелов $shots, попадений $hits, точность $currentAccuracy%")
    }
    fun placeShip(row: Int, col: Int) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = CellState.SHIP
        }
    }
    fun markShot(row: Int, col: Int, hit: Boolean) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = if (hit) CellState.HIT
            else CellState.MISS
        }
    }

}