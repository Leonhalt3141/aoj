
import java.util.Scanner

object ITP1_2_B {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val a = sc.nextInt()
    val b = sc.nextInt()
    val c = sc.nextInt()

    if (a < b  & b < c) println("Yes")
    else println("No")

  }
}
