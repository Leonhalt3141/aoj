import scala.io.StdIn
import math.{pow, sqrt}

object ITP1_10_C {

  def calculate_standard_score(scores: Array[Double]): Double = {
    val average = scores.sum / scores.length
    sqrt(scores.foldLeft(0.0)((acc, v) => acc + pow((v - average), 2)) / scores.length)
  }

  def main(args: Array[String]): Unit = {
    var n = StdIn.readInt()

    while (n > 0) {
      val scores = StdIn.readLine().split(' ').map(_.toDouble)

      println(calculate_standard_score(scores))
      n = StdIn.readInt()
    }
  }
}
