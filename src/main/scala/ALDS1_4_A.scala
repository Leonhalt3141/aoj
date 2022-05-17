
import scala.io.StdIn

object ALDS1_4_A {

  def linearSearch(L: List[Int], key: Int): Int = {
    var i = 0
    val A = L ::: key :: Nil

    while (A(i) != key) {
      i += 1
    }
    if (i == A.length - 1) return -1

    i

  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val S = StdIn.readLine().split(" ").map(_.toInt).toList

    val q = StdIn.readInt()
    val T = StdIn.readLine().split(" ").map(_.toInt).toList

    println(
    T.foldLeft(0)((a: Int, b: Int) => {
      if (linearSearch(S, b) != -1) a + 1
      else a
    })
    )
  }
}
