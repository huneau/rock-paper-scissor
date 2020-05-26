object Main {

    def main(args: Array[String]): Unit = {
        println("Game Rock Paper Scissor (Press Enter)")
        var game: Int = 0
        do {
            println("1: Player Vs Computer")
            println("2: Computer Vs Computer")
            println("3: Quit")
            game = Utils.selecter(3, System.in)
            if (game == 1) {
                Move.values.foreach((value: Move.Value) => println(value.id + 1 + ": " + value))
                val playerMove = Move.apply(Utils.selecter(Move.values.size, System.in) - 1)
                val computerChoice = Utils.getRandomChoice
                println("Player: " + playerMove + " VS Computer: " + computerChoice)
                Utils.victoryResult(playerMove, computerChoice)
            } else if (game == 2) {
                val computer1Choice = Utils.getRandomChoice
                val computer2Choice = Utils.getRandomChoice
                println("Computer1: " + computer1Choice + " VS Computer2: " + computer2Choice)
                Utils.victoryResult(computer1Choice, computer2Choice)
            }
        } while (game != 3);
    }

}
