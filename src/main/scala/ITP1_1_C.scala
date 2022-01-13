
import java.util.Scanner

object ITP1_1_C {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val a = sc.nextInt()
    val b = sc.nextInt()

    val area = a * b
    val perimeter = 2 * a + 2 * b

    println(area + " " + perimeter)

  }
}
