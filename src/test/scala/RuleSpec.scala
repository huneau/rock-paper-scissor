import org.scalatest.Matchers
import org.scalatest._

class RuleSpec extends FlatSpec with Matchers {

    "Paper" should "win against rock" in {
        val r = new Rule
        r.getWinner(Move.Paper, Move.Rock).get should be(Move.Paper)
    }

    "Rock" should "win against Scissor" in {
        val r = new Rule
        r.getWinner(Move.Scissor, Move.Rock).get should be(Move.Rock)
    }

    "Scissor" should "win against Paper" in {
        val r = new Rule
        r.getWinner(Move.Scissor, Move.Paper).get should be(Move.Scissor)
    }

    "No one" should "win" in {
        val r = new Rule
        a[NoSuchElementException] should be thrownBy {
            r.getWinner(Move.Scissor, Move.Scissor).get
        }
    }

}
