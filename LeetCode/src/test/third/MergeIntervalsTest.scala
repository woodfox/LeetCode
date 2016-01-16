package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

class MergeIntervalsTest extends FunSuite with ShouldMatchers {
  val m = new MergeIntervals

  test("should merge intervals") {
    m.merge(List[Interval]().asJava).asScala.toList should be(List())
    m.merge(ListBuffer(new Interval(1,3)).asJava).asScala.toList should be(List(new Interval(1,3)))
    m.merge(ListBuffer(new Interval(1,3), new Interval(8,10)).asJava).asScala.toList should be(List(new Interval(1,3), new Interval(8,10)))
    m.merge(ListBuffer(new Interval(1,3), new Interval(8,10), new Interval(2,7), new Interval(7,12)).asJava).asScala.toList should be(List(new Interval(1,12)))
    m.merge(ListBuffer(new Interval(1,3), new Interval(8,10), new Interval(2,6), new Interval(7,12)).asJava).asScala.toList should be(List(new Interval(1,6), new Interval(7,12)))
  }
}
