
import scala.collection.mutable
import scala.io.StdIn

object ALDS1_3_C {

  class LinkedList {

    case class LinkNode(v: Int) {
      val value: Int = v
      var prev: LinkNode = _
      var next: LinkNode = _
    }

    var head: LinkNode = _
    var tail: LinkNode = _

    def insert(x: Int): Unit = {
      val newNode = new LinkNode(x)
      if (head == null) {
        tail = newNode
      } else {
        head.prev = newNode
      }
      newNode.next = head
      head = newNode
    }

    def search(x: Int): (LinkNode, LinkNode) = {
      var current = head
      var prev: LinkNode = null
      while (current != null) {
        if (current.value == x) {
          return (prev, current)
        }
        prev = current
        current = current.next
      }
      (null, null)
    }

    def delete(x: Int): Unit = {
      val (prev, found) = search(x)
      if (found == head) {
        deleteFirst()
      } else if (found == tail) {
        deleteLast()
      } else if (found != null) {
        prev.next = found.next
        if (found.next != null) {
          found.next.prev = prev
        }
      }
    }

    def deleteLast(): Unit = {
      if (head == tail) {
        head = null
        tail = null
      } else {
        tail.prev.next = null
        tail = tail.prev
      }
    }

    def deleteFirst(): Unit = {
      if (head == tail) {
        head = null
        tail = null
      } else {
        head.next.prev = null
        head = head.next
      }
    }

    def printStr(): Unit = {
      var current = head
      val sb = new mutable.StringBuilder().append(current.value)
      current = current.next
      while (current != null) {
        sb.append(" ").append(current.value)
        current = current.next
      }
      println(sb)
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
