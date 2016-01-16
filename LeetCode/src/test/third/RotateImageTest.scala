package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class RotateImageTest extends FunSuite with ShouldMatchers {
  val r = new RotateImage

  test("should rotate image with lenth 5"){
    val image = Array(Array(1,2,3,4,5), Array(16,17,18,19,6), Array(15,24,25,20,7),Array(14,23,22,21,8),Array(13,12,11,10,9))
    val expected = Array(Array(13,14,15,16,1),Array(12,23,24,17,2),Array(11,22,25,18,3),Array(10,21,20,19,4),Array(9,8,7,6,5))
    r.rotate(image)
    image should be(expected)
  }

  test("should rotate image with length 1"){
    val image = Array(Array(1))
    val expected = Array(Array(1))
    r.rotate(image)
    image should be(expected)
  }

  test("should rotate image with length 2"){
    val image = Array(Array(1,2),Array(4,3))
    val expected = Array(Array(4,1),Array(3,2))
    r.rotate(image)
    image should be(expected)
  }

  test("should rotate image with length 3"){
    val image = Array(Array(1,2,3),Array(8,9,4),Array(7,6,5))
    val expected = Array(Array(7,8,1),Array(6,9,2),Array(5,4,3))
    r.rotate(image)
    image should be(expected)
  }
}
