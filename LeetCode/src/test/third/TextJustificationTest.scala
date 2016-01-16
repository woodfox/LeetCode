package third

import org.scalatest.FunSuite
import scala.collection.JavaConverters._
import org.scalatest.matchers.ShouldMatchers

class TextJustificationTest extends FunSuite with ShouldMatchers {
  val t = new TextJustification();

  test("should work"){
    val array = Array("This", "is", "an", "example", "of", "text", "justification.")
    val actual = t.fullJustify(array, 16)

    val expected = Array(
      "This    is    an",
      "example  of text",
      "justification.  ")
    actual.asScala.toList should be(expected.toList)
  }

  test("should work if only one line"){
    val array = Array("This", "is", "an")
    val actual = t.fullJustify(array, 16)

    val expected = Array(
      "This is an      ")
    actual.asScala.toList should be(expected.toList)
  }

  test("should work if two line"){
    val array = Array("This", "is", "an", "example")
    val actual = t.fullJustify(array, 16)

    val expected = Array(
      "This    is    an",
      "example         ")
    actual.asScala.toList should be(expected.toList)
  }
}
