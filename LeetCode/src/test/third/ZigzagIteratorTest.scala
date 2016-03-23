package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

class ZigzagIteratorTest extends FunSuite with ShouldMatchers {
  test("2 list should work") {
    val a:List[Integer] = List(1,2,3,4,5)
    val b:List[Integer] = List(6,7,8)
    val z = new ZigzagIterator(a, b)

    val r = ListBuffer[Integer]()
    while(z.hasNext) {
      r += z.next()
    }
    r.toList should be(List(1,6,2,7,3,8,4,5))
  }

  test("2 list should work if second is longer") {
    val a:List[Integer] = List(1,2)
    val b:List[Integer] = List(4,5,6,7,8,9)
    val z = new ZigzagIterator(a, b)

    val r = ListBuffer[Integer]()
    while(z.hasNext) {
      r += z.next()
    }
    r.toList should be(List(1,4,2,5,6,7,8,9))
  }

  test("2 list should work if first is empty") {
    val a:List[Integer] = List()
    val b:List[Integer] = List(4,5,6,7,8,9)
    val z = new ZigzagIterator(a, b)

    val r = ListBuffer[Integer]()
    while(z.hasNext) {
      r += z.next()
    }
    r.toList should be(List(4,5,6,7,8,9))
  }

  test("2 list should work if seocnd is empty") {
    val a:List[Integer] = List(1,2,3,4,5)
    val b:List[Integer] = List()
    val z = new ZigzagIterator(a, b)

    val r = ListBuffer[Integer]()
    while(z.hasNext) {
      r += z.next()
    }
    r.toList should be(List(1,2,3,4,5))
  }

  test("k list should work ") {
    val a:List[List[Integer]] = List(List(1,2),List(3,4,5,6),List(), List(7),List(8,9,10))
    val z = new ZigzagIteratorWithKList(a.map(_.asJava))

    val r = ListBuffer[Integer]()
    while(z.hasNext) {
      r += z.next()
    }
    r.toList should be(List(1,3,7,8,2,4,9,5,10,6))
  }

  test("k list should work if first is longer") {
    val a:List[List[Integer]] = List(List(1,2,3,4,5,6),List(7,8),List(9), List(10,11),List(12,13,14))
    val z = new ZigzagIteratorWithKList(a.map(_.asJava))

    val r = ListBuffer[Integer]()
    while(z.hasNext) {
      r += z.next()
    }
    r.toList should be(List(1,7,9,10,12,2,8,11,13,3,14,4,5,6))
  }

  test("queue version of k list should work ") {
    val a:List[List[Integer]] = List(List(1,2),List(3,4,5,6),List(), List(7),List(8,9,10))
    val z = new ZigzagIteratorWithKList_queue(a.map(_.asJava))

    val r = ListBuffer[Integer]()
    while(z.hasNext) {
      r += z.next()
    }
    r.toList should be(List(1,3,7,8,2,4,9,5,10,6))
  }

  test("queue version of k list should work if first is longer") {
    val a:List[List[Integer]] = List(List(1,2,3,4,5,6),List(7,8),List(9), List(10,11),List(12,13,14))
    val z = new ZigzagIteratorWithKList_queue(a.map(_.asJava))

    val r = ListBuffer[Integer]()
    while(z.hasNext) {
      r += z.next()
    }
    r.toList should be(List(1,7,9,10,12,2,8,11,13,3,14,4,5,6))
  }
}
