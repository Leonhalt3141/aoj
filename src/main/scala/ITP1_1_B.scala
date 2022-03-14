
import java.util.Scanner
import scala.math.pow

object ITP1_1_B {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val x = sc.nextInt()
    val result = pow(x, 3).toInt
    println(result)
  }
}
