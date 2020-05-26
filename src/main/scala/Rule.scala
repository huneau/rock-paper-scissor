import scala.collection.mutable

class Rule {

    private val winCombination = new mutable.HashMap[Move.Value, List[Move.Value]]()
    winCombination.addOne(Move.Paper, List(Move.Rock))
    winCombination addOne(Move.Rock, List(Move.Scissor))
    winCombination.addOne(Move.Scissor, List(Move.Paper))

    def getWinner(player1: Move.Value, player2: Move.Value): Option[Move.Value] = {
        if (player1 == player2) {
            return Option.apply(null)
        }
        val player1Win = winCombination.get(player1).exists((value: List[Move.Value]) => value.contains(player2))
        val player2Win = winCombination.get(player2).exists((value: List[Move.Value]) => value.contains(player1))
        if (player1Win) {
            return Option.apply(player1)
        } else if (player2Win) {
            return Option.apply(player2)
        }
        Option.apply(null)
    }
}
