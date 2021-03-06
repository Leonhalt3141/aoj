
import java.util.Scanner

object ITP1_7_C {

  def col2sum(x: Array[Int], y: Array[Int]): Array[Int] = {
    x.zipAll(y, 0, 0).map(pair => pair._1 + pair._2)
  }

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val r, c = sc.nextInt()

    val matrix: Array[Array[Int]] = Array.fill(r, c)(sc.nextInt)

    for (i <- 0 until  r) {
      println(matrix(i).mkString(" ") + " " + matrix(i).sum)
    }

    val last_row = matrix.reduce(col2sum)
    val total = last_row.sum
    println(last_row.mkString(" ") + " " + total)

  }
}
