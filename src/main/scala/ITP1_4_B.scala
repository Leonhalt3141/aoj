
import java.util.Scanner
import math.Pi

object ITP1_4_B {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val r= sc.nextDouble()

    val area = r * r * Pi
    val perimeter = 2 * Pi * r

    println("%.8f %.8f".format(area, perimeter))
  }
}
