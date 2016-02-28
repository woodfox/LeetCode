package third

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class EncodeDecodeStringTest extends FunSuite with ShouldMatchers {
  val e = new EncodeDecodeString

  test("should work") {
    var msg = List("I am Jerry", "who are you?", "what do you want to do")
    e.decode(e.encode(msg)).toList should be(msg)

    msg = List("I am Jerry with ##", "who are #123 you?", "what ##do you want to## do??")
    e.decode(e.encode(msg)).toList should be(msg)

    msg = List("################","I am #123#Jerry", "who###99### are you?", "what do you##0## want##99## to do##1199999##")
    e.decode(e.encode(msg)).toList should be(msg)
  }
}
