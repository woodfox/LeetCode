package third

import org.scalatest.{FunSpec, FunSuite}
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper
import scala.collection.JavaConverters._

class MergeKSortedListTest extends FunSpec with ListHelper with ShouldMatchers {
  val m = new MergeKSortedList

  describe("MergeKSortedList") {

    it("should merge correctly with only one list") {
      val list1 = createList(List(1,3,5,7,9))

      compareList(
        m.mergeKLists(List(list1).asJava),
        list1
      ) should be(true)
    }

    it("should merge correctly with two lists") {
      val list1 = createList(List(1,3,5,7,9))
      val list2 = createList(List(1,2,3,8,10))

      compareList(
        m.mergeKLists(List(list1, list2).asJava),
        createList(List(1, 1, 2, 3, 3, 5, 7, 8, 9, 10))
      ) should be(true)
    }
    it("should merge correctly with only one list node") {
      val list1 = createList(List(1,3,5,7,9))
      val list4 = createList(List(0))

      compareList(
        m.mergeKLists(List(list1, list4).asJava),
        createList(List(0, 1, 3, 5, 7, 9))
      ) should be(true)
    }
    it("should merge correctly with null list node") {
      val list1 = createList(List(1,3,5,7,9))
      val list6 = createList(Nil)

      compareList(
        m.mergeKLists(List(list1, list6).asJava),
        list1
      ) should be(true)
    }
    it("should merge correctly with multiple lists") {
      val list1 = createList(List(1,3,5,7,9))
      val list2 = createList(List(1,2,3,8,10))
      val list3 = createList(List(4,11,15))
      val list4 = createList(List(0))
      val list5 = createList(List(2,4,5,12))
      val list6 = createList(Nil)

      compareList(
        m.mergeKLists(List(list1, list2, list3, list4, list5, list6).asJava),
        createList(List(0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 7, 8, 9, 10, 11, 12, 15))
      ) should be(true)
    }
  }
}
