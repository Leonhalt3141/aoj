
import java.util.Scanner

object ITP1_2_D {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val W = sc.nextInt()
    val H = sc.nextInt()
    val x = sc.nextInt()
    val y = sc.nextInt()
    val r = sc.nextInt()

    val c0 = List(x, y + r)
    val c1 = List(x + r, y)
    val c2 = List(x, y - r)
    val c3 = List(x - r, y)

    if (c0(0) > W | c0(1) > H) {
      println("No")
    } else if (c1(0) > W | c1(1) > H) {
      println("No")
    } else if (c2(0) > W | c2(1) < 0) {
      println("No")
    } else if (c3(0) < 0 | c3(1) > H) {
      println("No")
    } else println("Yes")

  }
}
