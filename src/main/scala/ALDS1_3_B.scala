
import scala.io.StdIn

object ALDS1_3_B {

  case class Process(name: String, time: Int)

  class Que {
    var head: Int = 0
    var tail: Int = 0
    var time: Int = 0
    val Q: Array[Process] = Array.fill(100000)(Process("", 0))

    def initialize(): Unit = {
      head = 0
      tail = 0
    }

    def isEmpty: Boolean = head == tail

    def isFull: Boolean = head == (tail + 1) % Q.length

    def enqueue(x: Process): Unit = {
      if (isFull) {
        throw new RuntimeException("Overflow")
      }
      Q(tail) = x
      if (tail + 1 == Q.length)
        tail = 0
      else tail += 1
    }

    def dequeue(): Process = {
      if (isEmpty) throw new RuntimeException("Underflow")

      val x = Q(head)

      if (head + 1 == Q.length) head = 0
      else head += 1
      x
    }

  }

  def process(que: Que, limit: Int): Unit = {
    while (!que.isEmpty) {
      val p = que.dequeue()
      if (p.time == limit) {
        que.time += limit
        println(p.name + " " + que.time)
      } else if (p.time < limit) {
        que.time += p.time
        println(p.name + " " + que.time)
      } else if (p.time > limit) {
        que.time += limit
        que.enqueue(Process(p.name, p.time - limit))
      }
    }
  }

  def makeQue(n: Int): Que = {
    val que = new Que()
    (0 until n).foreach {_ =>
      val Array(name, time) = StdIn.readLine().split(" ")
      val process = Process(name, time.toInt)
      que.enqueue(process)
    }
    que
  }

  def main(args: Array[String]): Unit = {
    val Array(n, limit) = StdIn.readLine().split(" ").map(_.toInt)

    val que = makeQue(n)

    process(que, limit)
  }

}
