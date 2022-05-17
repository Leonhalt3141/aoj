
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object ALDS1_3_C {

  case class LinkNode(value: Int) {
    var prev: LinkNode = _
    var next: LinkNode = _
  }

  class LinkedList {

    var first = new LinkNode(-1)
    var last = new LinkNode(-1)

    first.next = last
    first.next.prev = first

    def insert(x: Int): Unit = {
      val newNode = new LinkNode(x)
      newNode.next = first.next
      if (first.next != null) first.next.prev = newNode
      first.next = newNode
      newNode.prev = first
    }

    def search(x: Int): LinkNode = {
      var node = first.next
      while (node != last && node.value != x) {
        node = node.next
      }
      node
    }

    def delete(node: LinkNode): Unit = {
      if (node != last) {
        node.prev.next = node.next
        node.next.prev = node.prev
      }
    }

    def delete(x: Int): Unit = delete(search(x))
    def deleteFirst(): Unit = delete(first.next)
    def deleteLast(): Unit = delete(last.prev)

    def printStr(): Unit = {
      val b = ArrayBuffer[Int]()
      var node = first.next

      while (node != last) {
        b += node.value
        node = node.next
      }
      println(b.mkString(" "))
    }
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val link: LinkedList = new LinkedList()

    (0 until n).foreach {_ =>
      val cmd = StdIn.readLine().split(" ")
      cmd(0) match {
        case "insert" => link.insert(cmd(1).toInt)
        case "delete" => link.delete(cmd(1).toInt)
        case "deleteFirst" => link.deleteFirst()
        case "deleteLast" => link.deleteLast()
      }
    }

    link.printStr()

  }
}
