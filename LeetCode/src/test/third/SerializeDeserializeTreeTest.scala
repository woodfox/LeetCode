package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class SerializeDeserializeTreeTest extends FunSuite with ShouldMatchers with TreeHelper {
  val t = new SerializeDeserializeTree

  test("should work" ) {
    var root = createTree(List())
    t.deserialize(t.serialize(root)) should be(root)

    root = createTree(List(1))
    t.deserialize(t.serialize(root)) should be(root)

    root = createTree(List(1,2))
    t.deserialize(t.serialize(root)) should be(root)

    root = createTree(List(1,2,3))
    t.deserialize(t.serialize(root)) should be(root)

    root = createTree(List(1,2,3,4,-1,-1,-1,-1,5,-1,-1))
    t.deserialize(t.serialize(root)) should be(root)

    root = createTree(List(12,3,4,5,-1,-1,-1,8,6,7,-1,9))
    t.deserialize(t.serialize(root)) should be(root)

    root = createTree(List(1,2,3,5,6,-1,-1,-1,-1,6,7))
    t.deserialize(t.serialize(root)) should be(root)
  }
}
