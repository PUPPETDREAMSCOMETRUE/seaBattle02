//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun printBothFields(player1: Player, player2: Player, showShips: Boolean = false) {
    if (player1.field.size != player2.field.size || player1.field[0].size != player2.field[0].size) {
        println("Поля должны быть одинакового размера!")
        return
    }
    val size = player1.field.size
    println("   === ${player1.name} ===             === ${player2.name} ===")
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
            val cell = player1.field[r][c]
            if (!showShips && cell == '#') {
                print(". ")
            }
            else {
                print("$cell ")
            }
        }
        print("      ")
        print("$r  ")
        for (c in 0 until size) {
            print("${player2.field[r][c]} ")
        }
        println()
    }
}

fun main() {
    val player1 = Player()
    val player2 = Player()

    player1.name = "Odasaku"
    player2.name = "Dazai"
    player1.field[3][2] = '#'
    player1.field[3][3] = '#'
    player2.field[3][2] = '#'
    player2.field[3][3] = '#'

    printBothFields(player1, player2)
}