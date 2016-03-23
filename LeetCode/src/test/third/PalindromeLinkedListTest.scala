package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class PalindromeLinkedListTest extends FunSuite with ShouldMatchers with ListHelper {
  test("should work") {
    val p = new PalindromeLinkedList

    p.isPalindrome(createList(List(1,2,3,1))) should be(false)
  }

  test("more space version should work") {
    val p = new PalindromeLinkedList

    p.isPalindrome_moreSpace(createList(List(1,2,3,1))) should be(false)
    p.isPalindrome_moreSpace(createList(List(1,2,2,1))) should be(true)
    p.isPalindrome_moreSpace(createList(List(1,2,1))) should be(true)
    p.isPalindrome_moreSpace(createList(List(1,1))) should be(true)
    p.isPalindrome_moreSpace(createList(List(-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,-10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557))) should be(true)
  }
}
