class Player {
    var name: String = ""
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
    fun printStatus(){
        println("Игрок $name: выстрелов $shots, попадений $hits")
    }
}