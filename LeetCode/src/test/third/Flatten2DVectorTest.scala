package third

import java.util

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

class Flatten2DVectorTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val list = List(List(1,2),List(),List(3),List(4,5)).map(_.asJava).asJava.asInstanceOf[util.List[util.List[Integer]]]
    val f = new Flatten2DVector(list)

    var result = ListBuffer[Int]()
    while(f.hasNext) {
      result append f.next()
    }

    result.toList should be(List(1,2,3,4,5))
  }

  test("should work 2") {
    val list = List(List(),List(),List(),List()).map(_.asJava).asJava.asInstanceOf[util.List[util.List[Integer]]]
    val f = new Flatten2DVector(list)

    val result = ListBuffer[Int]()
    while(f.hasNext) {
      result append f.next()
    }

    result.toList should be(List())
  }

  test("should work 3") {
    val list = List(List(),List(),List(),List(11)).map(_.asJava).asJava.asInstanceOf[util.List[util.List[Integer]]]
    val f = new Flatten2DVector(list)

    val result = ListBuffer[Int]()
    while(f.hasNext) {
      result append f.next()
    }

    result.toList should be(List(11))
  }
}
