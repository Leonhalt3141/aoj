
import scala.io.StdIn

object ALDS1_5_A extends App {
  val n = StdIn.readInt()
  val A = StdIn.readLine().split(" ").map(_.toInt)

  val q = StdIn.readInt()
  val M = StdIn.readLine().split(" ").map(_.toInt)

  def solve(i: Int, m: Int): Boolean = {
    if (m == 0) return true
    if (i >= n) return false

    // 最初の条件はmが0の時成り立つ。2つ目は組合せを再帰的に探索する
    val res = solve(i + 1, m) || solve(i + 1, m - A(i))
    res
  }

  M.foreach{v =>
    var check = false
    var i = 0
    while (i < n) {
      if (solve(i, v)) {
        check = true
        i = n
      }
      i += 1
    }
    if (check) println("yes")
    else println("no")
  }

}
