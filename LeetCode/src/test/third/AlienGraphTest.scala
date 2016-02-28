package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class AlienGraphTest extends FunSuite with ShouldMatchers {
  val g = new AlienGraph

  test("should work") {
    Set("abcdef","bacdef") should contain(g.alienOrder(List("abb","abc","abd","acd","acef","acff")))
    Set("wertf") should contain(g.alienOrder(List("wrt","wrf","er","ett","rftt")))
    Set("wertfg","gwertf","wgertf","wegrtf","wergtf","wertgf") should contain(g.alienOrder(List("wrt","wrf","wfg","er","ett","rftt")))
    Set("werztfg") should contain(g.alienOrder(List("wrt","wrf","wrg","wfg","er","ez","ett","rftt")))
  }
}
