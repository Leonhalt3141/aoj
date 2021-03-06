
import scala.io.StdIn
import math.{abs, pow}

object ITP1_10_D {

  def calculate_minkowski(xArray: Array[Double], yArray: Array[Double], p: Double): Double = {
    pow(
      xArray.zip(yArray).foldLeft(0.0) { (acc, v) =>
        acc + pow(abs(v._1 - v._2), p)
      }, 1 / p
    )
  }

  def calculate_chebyshev(xArray: Array[Double], yArray: Array[Double]): Double = {
    xArray.zip(yArray).map(v => abs(v._1 - v._2)).max
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val xArray = StdIn.readLine().split(" ").map(_.toDouble)
    val yArray = StdIn.readLine().split(" ").map(_.toDouble)

    println(calculate_minkowski(xArray, yArray, 1))
    println(calculate_minkowski(xArray, yArray, 2))
    println(calculate_minkowski(xArray, yArray, 3))
    println(calculate_chebyshev(xArray, yArray))
  }
}
