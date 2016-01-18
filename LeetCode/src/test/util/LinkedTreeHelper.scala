package util

import scala.collection.mutable

trait LinkedTreeHelper {
  def createLinkedTree(list: List[Int]): TreeLinkNode = {
    if(list.isEmpty) return null;

    val queue = mutable.Queue() ++ list

    mkTree(queue.dequeue(), queue)
  }

  private def mkTree(value: Int, queue: mutable.Queue[Int]): TreeLinkNode = {
    val node = new TreeLinkNode(value)
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

  def compareLinkedTree(a: TreeLinkNode, b: TreeLinkNode): Boolean = {
    if(a == null && b == null){
      true
    }else if(a != null && b != null) {
      a.`val` == b.`val` && compareLinkedTree(a.left, b.left) && compareLinkedTree(a.right, b.right) && compareLinkedTree(a.next, b.next)
    }else{
      false
    }
  }
}
