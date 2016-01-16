package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._

class InsertIntervalTest extends FunSuite with ShouldMatchers {
  val t = new InsertInterval

  test("should insert and merge intervals"){
    t.insert(List(new Interval(1,3)).asJava, new Interval(2,4)).asScala should be(List(new Interval(1,4)))
    t.insert(List(new Interval(1,3)).asJava, new Interval(0,7)).asScala should be(List(new Interval(0,7)))
    t.insert(List(new Interval(4,8)).asJava, new Interval(1,4)).asScala should be(List(new Interval(1,8)))
    t.insert(List(new Interval(4,8)).asJava, new Interval(2,3)).asScala should be(List(new Interval(2,3), new Interval(4,8)))
    t.insert(List(new Interval(1,3), new Interval(6,9)).asJava, new Interval(2,4)).asScala should be(List(new Interval(1,4), new Interval(6,9)))
  }
}
