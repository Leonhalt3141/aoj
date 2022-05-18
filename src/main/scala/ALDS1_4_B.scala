
import scala.io.StdIn

object ALDS1_4_B {

  def binarySearch(n: Int, key: Int, S: List[Int]): Int = {
    var left  = 0
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (S(mid) == key) return mid
      else if (key < S(mid)) right = mid
      else left = mid + 1
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val S = StdIn.readLine().split(" ").map(_.toInt).toList

    val q = StdIn.readInt()
    val T = StdIn.readLine().split(" ").map(_.toInt).toList

    val result = T.foldLeft(0)((a: Int, b: Int) => {
      if (binarySearch(n, b, S) != -1) a + 1
      else a
    })

    println(result)

  }
}
