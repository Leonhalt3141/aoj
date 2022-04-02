import scala.io.StdIn
import math.{sqrt, cos, toRadians}


object ITP1_10_B {

  def calculate_height(b: Double, c: Double): Double = {
    b * cos(toRadians(c))
  }

  def calculate_area(a: Double, height: Double): Double = {
    a * height / 2
  }

  def calculate_perimeter(): Double = {

  }

  def main(args: Array[String]): Unit = {
    val Array(a, b, c) = StdIn.readLine().split(" ").map(_.toDouble)



  }
}
