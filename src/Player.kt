class Player {
    var name: String = ""
    var shipsLeft: Int = 20
    var field: Array<CharArray> = Array(10) {
        CharArray(10) { '.'}
    }
    var shots: Int = 0
    var hits: Int = 0
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
        if (shots == 0) {
            return 0.0
        }
        return hits *  100.0 / shots
    }
    fun takeDamage(): Boolean {
        shipsLeft--
        if (isAlive()) {return true}
        else {return false}
    }
    fun registerShot(hit: Boolean) {shots++
    if (hit) {hits++} }
    fun reset() {
        shots = 0
        hits = 0
        shipsLeft = 20
        for (r in 0 until field.size) {
            for (c in 0 until field[r].size) {
                field[r][c] = '.'
            }
        }
    }
    fun printStatus(){
        val currentAccuracy = String.format("%.1f", accuracy())
        println("Игрок $name: палуб осталось $shipsLeft, выстрелов $shots, попадений $hits, точность $currentAccuracy%")
    }
}