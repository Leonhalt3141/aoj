
import scala.io.StdIn

object ALDS1_1_A {

  def insertionSort(A: Array[Int], v: Int, i: Int): Array[Int] = {
    var j = i - 1
    while (j >= 0 && A(j) > v) {
      A(j + 1) = A(j)
      j -= 1
    }

    A(j + 1) = v
    A
  }

  def main(args: Array[String]): Unit = {
    val N = StdIn.readInt()
    val A = StdIn.readLine().split(" ").map(_.toInt)

    println(A.mkString(" "))
    (1 until N).foreach { i =>
      val v = A(i)
      println(insertionSort(A, v, i).mkString(" "))
    }

  }
}
