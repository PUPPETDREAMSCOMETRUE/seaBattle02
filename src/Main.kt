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
    val player = Player()
    player.name = "Вы"

    player.registerShot(true)    // попал
    player.registerShot(false)   // промах
    player.registerShot(true)    // попал

    player.printStatus()
// Игрок Вы: палуб осталось 20, выстрелов 3, попаданий 2, точность 66.7%

    player.takeDamage()
    player.takeDamage()
    println(player.shipsLeft)    // 18
    println(player.isAlive())    // true

    player.reset()
    player.printStatus()
}