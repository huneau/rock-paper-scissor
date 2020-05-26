import java.io.{ByteArrayInputStream, InputStream}
import java.nio.charset.StandardCharsets
import java.util.stream.IntStream

import org.scalatest.Matchers
import org.scalatest._

class UtilsSpec extends FlatSpec with Matchers {

    "Random Choice" should "never throw" in {
        IntStream.range(0, 1000).forEach(_ => Utils.getRandomChoice)
    }

    "Victory Result" should "never throw" in {
        Utils.victoryResult(Move.Rock, Move.Rock)
        Utils.victoryResult(Move.Paper, Move.Paper)
        Utils.victoryResult(Move.Scissor, Move.Scissor)
        Utils.victoryResult(Move.Rock, Move.Paper)
        Utils.victoryResult(Move.Rock, Move.Scissor)
        Utils.victoryResult(Move.Paper, Move.Rock)
        Utils.victoryResult(Move.Paper, Move.Scissor)
        Utils.victoryResult(Move.Scissor, Move.Rock)
        Utils.victoryResult(Move.Scissor, Move.Paper)
    }

    "Selecter" should "return 1" in {
        val text = String.join("\n", "1")
        val stream: InputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8.name))
        Utils.selecter(1, stream) should be(1)
    }

    // a bit stuck here, even if I use the \n as a delimiter, the Scanner seems to consume all the Steam :/
    // I cannot go futher using this method
    //    "Selecter" should "return 2" in {
    //        val text = String.join("\n", "4", "2", "0")
    //        val stream: InputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8.name))
    //        Utils.selecter(2, stream) should be(2)
    //    }
    //
    //    "Selecter" should "return 3" in {
    //        val text = String.join("\n", "0", "3", "0")
    //        val stream: InputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8.name))
    //        Utils.selecter(3, stream) should be(3)
    //    }

}
