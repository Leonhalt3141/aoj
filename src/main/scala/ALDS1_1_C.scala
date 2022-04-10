
import scala.io.StdIn
import math.sqrt

object ALDS1_1_C {

  def checkLargeNumber(v: Int): Int = {
    var i = 3
    while (i <= sqrt(v)) {
      if (v % i == 0){
        return 0
      }
      i += 2
    }
    1
  }

  def isPrimeNumber(v: Int): Int = v match {
    case 0 => 0
    case 2 => 1
    case a if a < 2 | a % 2 == 0 => 0
    case c => checkLargeNumber(c)
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val values = Array.fill[Int](n)(StdIn.readInt())

    val count = values.foldLeft(0)((acc, v) => isPrimeNumber(v) + acc)
    println(count)
  }
}
