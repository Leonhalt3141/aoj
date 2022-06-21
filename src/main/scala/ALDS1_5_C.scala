
import scala.io.StdIn
import math.{Pi, sin, cos}

object ALDS1_5_C {

  val angle: Double = Pi / 3
  val cosA: Double = cos(angle)
  val sinA: Double = sin(angle)

  def koch(p1: Array[Double], p2: Array[Double]): Array[Array[Double]] = {
    val s_x = (2 * p1(0) + p2(0)) / 3
    val s_y = (2 * p1(1) + p2(1)) / 3

    val t_x = (p1(0) + 2 * p2(0)) / 3
    val t_y = (p1(1) + 2 * p2(1)) / 3

    val u_x = (t_x - s_x) * cosA - (t_y - s_y) * sinA + s_x
    val u_y = (t_x - s_x) * sinA + (t_y - s_y) * cosA + s_y

    Array[Array[Double]](Array[Double](s_x, s_y), Array[Double](u_x, u_y), Array[Double](t_x, t_y))
  }

  def KochCurve(n: Int, p1: Array[Double], p2: Array[Double]): Unit = {
    if (n == 0) return ;

    val Array(s, u, t) = koch(p1, p2)

    KochCurve(n - 1, p1, s)
    println(s.mkString(" "))

    KochCurve(n - 1, s, u)
    println(u.mkString(" "))

    KochCurve(n - 1, u, t)
    println(t.mkString(" "))

    KochCurve(n - 1, t, p2)
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val p1 = Array[Double](0, 0)
    val p2 = Array[Double](100 , 0)

    println(p1.mkString(" "))
    KochCurve(n, p1, p2)
    println(p2.mkString(" "))
  }
}
