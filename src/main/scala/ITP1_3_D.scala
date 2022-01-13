
import java.util.Scanner

object ITP1_3_D {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val a = sc.nextInt()
    val b = sc.nextInt()
    val c = sc.nextInt()

    var count = 0

    for (div <- Range(a, b+1)) {
      if (c % div == 0) count += 1
    }

    println(count)
  }

}
