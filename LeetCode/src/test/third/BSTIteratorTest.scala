package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class BSTIteratorTest extends FunSuite with ShouldMatchers with TreeHelper {
  test("should work") {
    val root = createTree(List(5,3,8,1,4,-1,-1,-1,-1,7,9,6))
    val b = new BSTIterator(root)

    val result = scala.collection.mutable.ListBuffer[Int]()
    while(b.hasNext){
      result += b.next()
    }
    result.toList should be(List(1,3,4,5,6,7,8,9))
  }
}
