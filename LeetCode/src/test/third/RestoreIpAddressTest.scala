package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class RestoreIpAddressTest extends FunSuite with ShouldMatchers {
  val r = new RestoreIpAddress

  test("Should work") {
    r.restoreIpAddresses("0000").toSet should be(Set("0.0.0.0"))
    r.restoreIpAddresses("111").toSet should be(Set())
    r.restoreIpAddresses("1111").toSet should be(Set("1.1.1.1"))
    r.restoreIpAddresses("10111").toSet should be(Set("1.0.1.11", "1.0.11.1", "10.1.1.1"))
    r.restoreIpAddresses("12345").toSet should be(Set("12.3.4.5", "1.23.4.5", "1.2.34.5", "1.2.3.45"))
    r.restoreIpAddresses("100100100100").toSet should be(Set("100.100.100.100"))
    r.restoreIpAddresses("25525511135").toSet should be(Set("255.255.11.135", "255.255.111.35"))
  }
}
