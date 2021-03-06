
import scala.io.StdIn
import math.{sqrt, pow}

object ITP1_10_A {

  def distance(x1: Double, y1: Double, x2: Double, y2: Double): Double = {
    sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2))
  }

  def main(args: Array[String]): Unit = {
    val Array(x1, y1, x2, y2) = StdIn.readLine().split(" ").map(_.toDouble)

    println(distance(x1, y1, x2, y2))

  }
}
