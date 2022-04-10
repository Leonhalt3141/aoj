
import scala.annotation.tailrec
import scala.io.StdIn

object ALDS1_1_B {

  @tailrec
  def gcd(x: Int, y: Int): Int = (x, y) match {
    case (a, 0) => a
    case (b, c) => gcd(c, b % c)
  }

  @tailrec
  def calculateGCD(x: Int, y: Int, d: Int): Int = (x, y, d) match {
    case (a, b, c) if a % c == 0 & b % c == 0 => c
    case _ => calculateGCD(x, y, d - 1)

  }

  def main(args: Array[String]): Unit = {
    val Array(x, y) = StdIn.readLine().split(" ").map(_.toInt)

//    val d = calculateGCD(x, y, y)
    val d = gcd(x, y)
    println(d)
  }
}
