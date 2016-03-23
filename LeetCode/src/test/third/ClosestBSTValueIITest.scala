package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper
import scala.collection.JavaConversions._

class ClosestBSTValueIITest extends FunSuite  with ShouldMatchers with TreeHelper {
  val c = new ClosestBSTValueII

  test("should work") {
    c.closestKValues(createTree(List(4,2,6)), 1.3, 1).toList should be(List(2))
    c.closestKValues(createTree(List(4,2,6)), 1.3, 2).toList should be(List(2,4))
    c.closestKValues(createTree(List(4,2,6)), 1.3, 3).toList should be(List(2,4,6))

    c.closestKValues(createTree(List(4,2,6)), 2.3, 1).toList should be(List(2))
    c.closestKValues(createTree(List(4,2,6)), 2.3, 2).toList should be(List(2,4))
    c.closestKValues(createTree(List(4,2,6)), 2.3, 3).toList should be(List(2,4,6))

    c.closestKValues(createTree(List(4,2,6)), 4.3, 1).toList should be(List(4))
    c.closestKValues(createTree(List(4,2,6)), 4.3, 2).toList should be(List(4,6))
    c.closestKValues(createTree(List(4,2,6)), 4.3, 3).toList should be(List(4,6,2))

    c.closestKValues(createTree(List(4,2,6)), 6.3, 1).toList should be(List(6))
    c.closestKValues(createTree(List(4,2,6)), 6.3, 2).toList should be(List(6,4))
    c.closestKValues(createTree(List(4,2,6)), 6.3, 3).toList should be(List(6,4,2))

    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 1).toList should be(List(2))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 2).toList should be(List(2,3))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 3).toList should be(List(2,3,1))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 4).toList should be(List(2,3,1,4))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 5).toList should be(List(2,3,1,4,5))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 6).toList should be(List(2,3,1,4,5,6))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 7).toList should be(List(2,3,1,4,5,6,7))
  }

  test("priorityQueue version should work") {
    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 1.3, 1).toList should be(List(2))
    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 1.3, 2).toList should be(List(2,4))
    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 1.3, 3).toList should be(List(2,4,6))

    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 2.3, 1).toList should be(List(2))
    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 2.3, 2).toList should be(List(2,4))
    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 2.3, 3).toList should be(List(2,4,6))

    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 4.3, 1).toList should be(List(4))
    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 4.3, 2).toList should be(List(4,6))
    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 4.3, 3).toList should be(List(4,6,2))

    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 6.3, 1).toList should be(List(6))
    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 6.3, 2).toList should be(List(6,4))
    c.closestKValues_priorityQueue(createTree(List(4,2,6)), 6.3, 3).toList should be(List(6,4,2))

    c.closestKValues_priorityQueue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 1).toList should be(List(2))
    c.closestKValues_priorityQueue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 2).toList should be(List(2,3))
    c.closestKValues_priorityQueue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 3).toList should be(List(2,3,1))
    c.closestKValues_priorityQueue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 4).toList should be(List(2,3,1,4))
    c.closestKValues_priorityQueue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 5).toList should be(List(2,3,1,4,5))
    c.closestKValues_priorityQueue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 6).toList should be(List(2,3,1,4,5,6))
    c.closestKValues_priorityQueue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 7).toList should be(List(2,3,1,4,5,6,7))
  }

  test("best version should work") {
    c.closestKValues(createTree(List(4,2,6)), 1.3, 1).toList should be(List(2))
    c.closestKValues(createTree(List(4,2,6)), 1.3, 2).toList should be(List(2,4))
    c.closestKValues(createTree(List(4,2,6)), 1.3, 3).toList should be(List(2,4,6))

    c.closestKValues(createTree(List(4,2,6)), 2.3, 1).toList should be(List(2))
    c.closestKValues(createTree(List(4,2,6)), 2.3, 2).toList should be(List(2,4))
    c.closestKValues(createTree(List(4,2,6)), 2.3, 3).toList should be(List(2,4,6))

    c.closestKValues(createTree(List(4,2,6)), 4.3, 1).toList should be(List(4))
    c.closestKValues(createTree(List(4,2,6)), 4.3, 2).toList should be(List(4,6))
    c.closestKValues(createTree(List(4,2,6)), 4.3, 3).toList should be(List(4,6,2))

    c.closestKValues(createTree(List(4,2,6)), 6.3, 1).toList should be(List(6))
    c.closestKValues(createTree(List(4,2,6)), 6.3, 2).toList should be(List(6,4))
    c.closestKValues(createTree(List(4,2,6)), 6.3, 3).toList should be(List(6,4,2))

    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 1).toList should be(List(2))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 2).toList should be(List(2,3))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 3).toList should be(List(2,3,1))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 4).toList should be(List(2,3,1,4))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 5).toList should be(List(2,3,1,4,5))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 6).toList should be(List(2,3,1,4,5,6))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 7).toList should be(List(2,3,1,4,5,6,7))
  }

  test("slow version should work") {
    c.closestKValues(createTree(List(4,2,6)), 1.3, 1).toList should be(List(2))
    c.closestKValues(createTree(List(4,2,6)), 1.3, 2).toList should be(List(2,4))
    c.closestKValues(createTree(List(4,2,6)), 1.3, 3).toList should be(List(2,4,6))

    c.closestKValues(createTree(List(4,2,6)), 2.3, 1).toList should be(List(2))
    c.closestKValues(createTree(List(4,2,6)), 2.3, 2).toList should be(List(2,4))
    c.closestKValues(createTree(List(4,2,6)), 2.3, 3).toList should be(List(2,4,6))

    c.closestKValues(createTree(List(4,2,6)), 4.3, 1).toList should be(List(4))
    c.closestKValues(createTree(List(4,2,6)), 4.3, 2).toList should be(List(4,6))
    c.closestKValues(createTree(List(4,2,6)), 4.3, 3).toList should be(List(4,6,2))

    c.closestKValues(createTree(List(4,2,6)), 6.3, 1).toList should be(List(6))
    c.closestKValues(createTree(List(4,2,6)), 6.3, 2).toList should be(List(6,4))
    c.closestKValues(createTree(List(4,2,6)), 6.3, 3).toList should be(List(6,4,2))

    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 1).toList should be(List(2))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 2).toList should be(List(2,3))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 3).toList should be(List(2,3,1))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 4).toList should be(List(2,3,1,4))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 5).toList should be(List(2,3,1,4,5))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 6).toList should be(List(2,3,1,4,5,6))
    c.closestKValues(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.3, 7).toList should be(List(2,3,1,4,5,6,7))
  }
}
