
import scala.io.StdIn

object ALDS1_2_A {


  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val A = StdIn.readLine().split(" ").map(_.toInt)

    var count = 0
    var i = 0
    var flag = true
    while (flag) {
      flag = false
      (i + 1 until n).reverse.foreach { j =>
        if (A(j) < A(j-1)) {
          val temp1 = A(j)
          val temp2 = A(j-1)

          A(j) = temp2
          A(j-1) = temp1
          flag = true
          count += 1
        }
      }
      i += 1
    }
    println(A.mkString(" "))
    println(count)
  }
}
