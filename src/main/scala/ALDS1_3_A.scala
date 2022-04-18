
import scala.io.StdIn

object ALDS1_3_A {

  class Stack {
    var top: Int = 0
    val S: Array[String] = Array.fill(200)("")

    def initialize(): Unit = {
      top = 0
    }

    def isEmpty: Boolean = top == 0

    def isFull: Boolean = top >= S.length - 1

    def push(x: String): Unit = {
      if (isFull) {
        throw new RuntimeException("Overflow")
      }

      top += 1
      S(top) = x
    }

    def pop(): String = {
      if (isEmpty) throw new RuntimeException("Underflow")

      top -= 1
      S(top + 1)
    }

  }

  def operator(a: Int, b: Int, operator: String): Int = (a, b, operator) match {
    case (a1, b1, "+") => a1 + b1
    case (a2, b2, "-") => b2 - a2
    case (a3, b3, "*") => a3 * b3
  }

  def process(values: List[String], stack: Stack): Unit = {
    for (value <- values) {
      if (value(0).isDigit) stack.push(value)
      else stack.push(operator(stack.pop().toInt, stack.pop().toInt, value).toString)
    }
  }

  def main(args: Array[String]): Unit = {
    val values = StdIn.readLine().split(" ").toList

    val stack = new Stack()
    process(values, stack)
    println(stack.S(stack.top))

  }
}
