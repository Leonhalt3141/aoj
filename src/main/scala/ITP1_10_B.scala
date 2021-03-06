import scala.io.StdIn
import math.{cos, pow, sin, sqrt, toRadians}


object ITP1_10_B {

  def calculate_height(b: Double, c: Double): Double = {
    b * sin(toRadians(c))
  }

  def calculate_area(a: Double, height: Double): Double = {
    a * height / 2
  }

  def calculate_perimeter(a: Double, b: Double,  c: Double): Double = {
    val e = sqrt(pow(calculate_height(b, c), 2) + pow(a - b * cos(toRadians(c)), 2))
    a + b + e
  }

  def main(args: Array[String]): Unit = {
    val Array(a, b, c) = StdIn.readLine().split(" ").map(_.toDouble)

    val height = calculate_height(b, c)
    val area = calculate_area(a, height)
    val perimeter = calculate_perimeter(a, b, c)

    println(area)
    println(perimeter)
    println(height)

  }
}
