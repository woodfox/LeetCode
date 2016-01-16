package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

class ConcatenationOfWordsTest extends FunSuite with ShouldMatchers {
  val s = new ConcatenationOfWords

  test("should find all substring index"){
    s.findSubstring("aaa", Array("a", "b")).asScala.toList should be(List())
    s.findSubstring("abababab", Array("a", "b", "a")).asScala.toList should be(List(0,2,4))
    s.findSubstring("fbar", Array("foo", "bar")).asScala.toList should be(List())
    s.findSubstring("barfoothefoobarman", Array("foo", "bar")).asScala.toList should be(List(0,9))
    s.findSubstring("barfoothefoobarfoo", Array("foo", "bar")).asScala.toList should be(List(0,9,12))
    s.findSubstring("barfoothefoobarman", Array()).asScala.toList should be(List())
    s.findSubstring("barfoothefoobarman", Array("foo")).asScala.toList should be(List(3,9))
    s.findSubstring("barfortheforbarman", Array("foo", "bar")).asScala.toList should be(List())
  }

  test("scala function should find all substring index"){
    scalaFindSubString("aaa", Array("a", "b")) should be(List())
    scalaFindSubString("abababab", Array("a", "b", "a")) should be(List(0,2,4))
    scalaFindSubString("fbar", Array("foo", "bar")) should be(List())
    scalaFindSubString("barfoothefoobarman", Array("foo", "bar")) should be(List(0,9))
    scalaFindSubString("barfoothefoobarfoo", Array("foo", "bar")) should be(List(0,9,12))
    scalaFindSubString("barfoothefoobarman", Array()) should be(List())
    scalaFindSubString("barfoothefoobarman", Array("foo")) should be(List(3,9))
    scalaFindSubString("barfortheforbarman", Array("foo", "bar")) should be(List())
  }

  //Scala function is much shorter than Java function due to the collection library!
  def scalaFindSubString(s: String, array: Array[String]): List[Int] = {
    val result = collection.mutable.ListBuffer[Int]()
    if(array.isEmpty) return result.toList

    val map = collection.mutable.Map[String, Int]()
    array.map { t =>
      val count = map.get(t).getOrElse(0)
      map.put(t, count+1)
    }

    val n = array.length
    val length = array.head.length
    for(i <- 0 to s.length - n*length){
      val subMap = collection.mutable.Map[String, Int]()

      for(j <- 0 to n-1) {
        val t = s.substring(i+j*length, i+j*length+length)
        val count = subMap.get(t).getOrElse(0)
        subMap.put(t, count+1)
      }

      if(map == subMap){
        result += i
      }
    }

    result.toList
  }

}
