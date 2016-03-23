package other

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class SearchSuggestionTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val t = new SearchSuggestion(List("jerry tao", "jim zhe", "xiao jem", "tom li", "hao de"))
    t.suggest("j").toSet should be(Set("jerry tao", "jim zhe", "xiao jem"))
    t.suggest("je").toSet should be(Set("jerry tao","xiao jem"))
    t.suggest("jerr").toSet should be(Set("jerry tao"))
    t.suggest("jem").toSet should be(Set("xiao jem"))
    t.suggest("d").toSet should be(Set("hao de"))

    val t2 = new SearchSuggestion(List("jerry last", "last jim", "last jem", "tom last", "hao last", "xxx last", "last xx", "yy last", "last yy", "zz last", "last zz"))
    t2.suggest("last").size should be(10)
  }
}
