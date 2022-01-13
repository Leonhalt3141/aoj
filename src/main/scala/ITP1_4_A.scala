
import java.util.Scanner


object ITP1_4_A {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val a = sc.nextInt()
    val b = sc.nextInt()

    val d = a / b
    val r = a % b
    val f = a.toDouble / b.toDouble

    println("%d %d %.8f".format(d, r, f))

  }
}
