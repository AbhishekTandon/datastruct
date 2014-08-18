import org.scalatest._
import CustomMatchers._

class ExampleSpec extends FlatSpec with Matchers {

  "First test" should " run with exception"  in{
    Array(1, 2) should not equal (Array(2, 2))
    Array(1, 2) should be (Array(1, 2))
  }

  "First customer matcher" should "work" in {

    1 should equalInt(1)
  }

}


import org.scalatest._
import matchers._

trait CustomMatchers {

  class IntMatcher(expected: Int) extends Matcher[Int] {

    def apply(left: Int) = {

      MatchResult(
        left == expected,
        s"""actual value $left did not equal with expected "$expected"""",
        s"""actual value $left equal to expected "$expected""""
      )
    }
  }

  def equalInt(expected: Int) = new IntMatcher(expected)
}

object CustomMatchers extends CustomMatchers