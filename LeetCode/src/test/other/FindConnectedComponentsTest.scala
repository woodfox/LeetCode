package other

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers
import util.UndirectedGraphNode

class FindConnectedComponentsTest extends FunSuite with ShouldMatchers {
  val t = new FindConnectedComponents

  test("should work") {
    val a = new UndirectedGraphNode(1)
    val b = new UndirectedGraphNode(2)
    val c = new UndirectedGraphNode(3)
    val d = new UndirectedGraphNode(4)
    val e = new UndirectedGraphNode(5)
    a.neighbors.add(c)
    c.neighbors.add(a)
    b.neighbors.add(c)
    c.neighbors.add(b)
    d.neighbors.add(e)
    e.neighbors.add(d)

    t.connectedSet(Set(a,b,c,d,e)).map(_.toSet).toSet should be(Set(Set(a,b,c),Set(d,e)))
  }

  test("connected graph should work") {
    val a = new UndirectedGraphNode(1)
    val b = new UndirectedGraphNode(2)
    val c = new UndirectedGraphNode(3)
    val d = new UndirectedGraphNode(4)
    val e = new UndirectedGraphNode(5)
    a.neighbors.add(c)
    c.neighbors.add(a)
    b.neighbors.add(c)
    c.neighbors.add(b)

    c.neighbors.add(e)
    e.neighbors.add(c)

    d.neighbors.add(e)
    e.neighbors.add(d)

    t.connectedSet(Set(a,b,c,d,e)).map(_.toSet).toSet should be(Set(Set(a,b,c,d,e)))
  }

  test("isoloated graph should work") {
    val a = new UndirectedGraphNode(1)
    val b = new UndirectedGraphNode(2)
    val c = new UndirectedGraphNode(3)
    val d = new UndirectedGraphNode(4)
    val e = new UndirectedGraphNode(5)

    t.connectedSet(Set(a,b,c,d,e)).map(_.toSet).toSet should be(Set(Set(a),Set(b),Set(c),Set(d),Set(e)))
  }
}
