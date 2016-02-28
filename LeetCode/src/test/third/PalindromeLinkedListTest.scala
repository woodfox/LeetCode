package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class PalindromeLinkedListTest extends FunSuite with ShouldMatchers with ListHelper {
  test("should work") {
    val p = new PalindromeLinkedList

    p.isPalindrome(createList(List(1,2,3,1))) should be(false)
  }
}
