
import scala.io.StdIn

object ALDS1_2_B {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val A = StdIn.readLine().split(" ").map(_.toInt)

    var count = 0

    (0 until n).foreach { i =>
      var minj = i
      (i until n).foreach { j =>
        if (A(j) < A(minj)) {
          minj = j
        }
      }

      if (i != minj) {
        val temp1 = A(i)
        val temp2 = A(minj)

        A(i) = temp2
        A(minj) = temp1
        count += 1
      }

    }

    println(A.mkString(" "))
    println(count)

  }
}
