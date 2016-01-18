package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SurroundedRegionsTest extends FunSuite with ShouldMatchers {
  val s = new SurroundedRegions

  private def createArray(strings: Array[String]): Array[Array[Char]] = {
    strings.map(s => s.toCharArray)
  }

  test("should work") {
    val array = createArray(Array("XXXX","XOOX","OXXO","XOOX"))
    s.solve(array)
    array should be(createArray(Array("XXXX","XXXX","OXXO","XOOX")))

    val array2 = createArray(Array("XXXX","XOOX","OOXO","XOOX"))
    s.solve(array2)
    array2 should be(createArray(Array("XXXX","XOOX","OOXO","XOOX")))

    val array3 = createArray(Array("XXXX","XOOX","XOXO","XXOX"))
    s.solve(array3)
    array3 should be(createArray(Array("XXXX","XXXX","XXXO","XXOX")))
  }
}
