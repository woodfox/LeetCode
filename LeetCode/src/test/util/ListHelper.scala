package util

import java.util

import second.ListNode
import scala.collection.JavaConverters._

trait ListHelper {
  def createList(list: List[Int]): ListNode = {
    list match {
      case Nil =>
        null
      case first :: tail =>
        val head = new ListNode(first)
        val nodeList = tail.map(new ListNode(_))
        nodeList.foldLeft(head) { (prev, node) =>
          prev.next = node
          node
        }
        head
    }
  }

  def compareList(a: ListNode, b: ListNode): Boolean = {
    val s1 = printList(a)
    val s2 = printList(b)
    if(s1 != s2) {
      println(s"List [$s1] is not equal to List [$s2]")
    }

    s1 == s2
  }

  def printList(a: ListNode): String = {
    if(Option(a).isEmpty) return ""

    val others = printList(a.next)
    Seq(a.`val`, others).filter(_ != "").mkString(",")
  }

  def convertJavaListToSet[T](array: util.List[util.List[T]]): Set[List[T]] = {
    array.asScala.map(_.asScala.toList).toSet
  }

  def convertJavaList[T](array: util.List[util.List[T]]): List[List[T]] = {
    array.asScala.map(_.asScala.toList).toList
  }
}