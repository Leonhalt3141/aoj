
import java.util.Scanner

object ITP1_6_A {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val n = sc.nextInt()
    val array = (1 to n).map(_ => sc.nextInt()).toArray

    println(array.reverse.mkString(" "))

  }
}
