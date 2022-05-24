
import scala.annotation.tailrec
import scala.io.StdIn

object ALDS1_4_B {

  @tailrec
  def binarySearch(func: Int => Int, left: Int, right: Int): Int = (left, right) match {
    case (l1, r1) if (r1 - l1 <= 1) => func(l1)
    case (l2, r2) if (func((l2+r2) / 2) < 1) => binarySearch(func, (l2 + r2) / 2, r2)
    case _ => binarySearch(func, left, (left + right) / 2)
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val S = StdIn.readLine().split(" ").map(_.toInt)

    val q = StdIn.readInt()
    val T = StdIn.readLine().split(" ").map(_.toInt)

    val f = (ar: Seq[Int], a: Int) => (x: Int) => ar(x) - a

    val result = T.foldLeft(0)((a: Int, b: Int) => {
      if (binarySearch(f(S, b), 0, n) == 0) a + 1
      else a
    })

    println(result)

  }
}
