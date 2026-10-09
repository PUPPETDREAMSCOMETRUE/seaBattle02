//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun createEmptyField(size: Int = 10): Array<CharArray>{
    return Array(size) { CharArray(size) {'.'} }
}
fun printField(field: Array<CharArray>, title: String, showShips: Boolean = true, debug: Boolean = false) {
    println("=== $title ===")
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
fun printBothFields(enemyField: Array<CharArray>, playerField: Array<CharArray>, showEnemyShips: Boolean = false) {
    if (enemyField.size != playerField.size || enemyField[0].size != playerField[0].size) {
        println("Поля должны быть одинакового размера!")
        return
    }
    val size = enemyField.size
    println("   === Ваше поле ===             === поле врага ===")
    print("   ")
    for (c in 0 until size) {
        print("$c ")
    }
    print("      ")
    print("   ")
    for (c in 0 until size) {
        print("$c ")
    }
    println()
    for (r in 0 until size) {
        print("$r  ")
        for (c in 0 until size) {
            val cell = enemyField[r][c]
            if (!showEnemyShips && cell == '#') {
                print(". ")
            }
            else {
                print("$cell ")
            }
        }
        print("      ")
        print("$r  ")
        for (c in 0 until size) {
            print("${playerField[r][c]} ")
        }
        println()
    }
}

fun main() {
    val player1 = Player()
    val player2 = Player()

    player1.name = "Odasaku"
    player2.name = "Dazai"

    println(player1.name)
    println(player2.name)
}