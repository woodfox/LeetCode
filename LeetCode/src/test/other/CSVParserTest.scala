package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class CSVParserTest extends FunSuite with ShouldMatchers {
  val t = new CSVParser

  test("should work"){
    t.parse("a,b") should be("a|b")
    t.parse("abcdefg") should be("abcdefg")
    t.parse("\"abc\"\"de\"\"fg\"") should be("abc\"de\"fg")
    t.parse("\"\\\"\\\"\\\"Alexandra Alex\\\"\\\"\\\"\"") should be("\\\"\\\"\\\"Alexandra Alex\\\"\\\"\\\"")
    t.parse("Jane,Roberts,janer@msn.com,\\\"San Francisco, CA\\\",0") should be("Jane|Roberts|janer@msn.com|\\\"San Francisco, CA\\\"|0")
    t.parse("a,b,\"ab,cd\",\"ef,\"\",gh\"\"hmmm\",haha") should be("a|b|ab,cd|ef,\",gh\"hmmm|haha")
  }
}
