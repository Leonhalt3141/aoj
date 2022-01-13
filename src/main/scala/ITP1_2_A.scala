
import java.util.Scanner

object ITP1_2_A {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val a = sc.nextInt()
    val b = sc.nextInt()

    if (a < b) println("a < b")
    else if (a > b) println("a > b")
    else println("a == b")

  }
}
