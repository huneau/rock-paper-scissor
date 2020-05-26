import java.io.InputStream
import java.util.{InputMismatchException, Scanner}

import scala.util.Random

object Utils {

    private val rule = new Rule()

    def getRandomChoice: Move.Value = {
        Move.apply(Random.between(0, Move.values.size))
    }

    def victoryResult(choice1: Move.Value, choice2: Move.Value): Unit = {
        val winner: Option[Move.Value] = rule.getWinner(choice1, choice2)
        if (winner.isEmpty) {
            println("Nobody Win")
        }
        winner.foreach((value: Move.Value) => {
            println(value + " Win")
        })
    }

    def selecter(maxValue: Int, source: InputStream): Int = {
        var selected = false
        var scannedValue = 0
        do {
            try {
                val scanner = new Scanner(source)
                scanner.useDelimiter("\n");
                scannedValue = scanner.nextInt()
                if (scannedValue > maxValue || scannedValue < 1) {
                    println("Wrong Value should be between 1 and " + maxValue)
                }
                selected = true
            } catch {
                case _: InputMismatchException => selected = false
                    println("Wrong Value should be between 1 and " + maxValue)
            }
        } while (!selected || scannedValue > maxValue || scannedValue < 1)
        scannedValue
    }

}
