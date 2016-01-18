package util

import scala.collection.mutable

trait TreeHelper {
  def createTree(list: List[Int]): TreeNode = {
    if(list.isEmpty) return null;

    val queue = mutable.Queue() ++ list

    mkTree(queue.dequeue(), queue)
  }

  private def mkTree(value: Int, queue: mutable.Queue[Int]): TreeNode = {
    val node = new TreeNode(value)
    val left = if(queue.isEmpty) -1 else queue.dequeue()
    val right = if(queue.isEmpty) -1 else queue.dequeue()
    if(left != -1) {
      node.left = mkTree(left, queue)
    }
    if(right != -1){
      node.right = mkTree(right, queue)
    }
    node
  }

  def compareTree(a: TreeNode, b: TreeNode): Boolean = {
    if(a == null && b == null){
      true
    }else if(a != null && b != null) {
      a.`val` == b.`val` && compareTree(a.left, b.left) && compareTree(a.right, b.right)
    }else{
      false
    }
  }
}
