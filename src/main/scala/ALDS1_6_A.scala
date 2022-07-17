
import scala.io.StdIn

object ALDS1_6_A {

  def countingSort(A: Array[Int], B: Array[Int], k: Int, n: Int): Unit = {
    val C = Array.fill(k+1)(0)

    for (j <- 0 until   n) C(A(j)) += 1

    for (i <- 1 to  k) C(i) = C(i) + C(i - 1)

    for (a <- A) {
      B(C(a) - 1) = a
      C(a) -= 1
    }
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val A = StdIn.readLine().split(" ").map(_.toInt)

    val B = Array.fill(n)(0)
    val k = A.max

    countingSort(A, B, k, n)
    println(B.mkString(" "))
  }
}
