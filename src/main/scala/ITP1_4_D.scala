
import java.util.Scanner

object ITP1_4_D {
  def main(args: Array[String]): Unit = {

    val sc = new Scanner(System.in)

    val n = sc.nextInt()

    var i = 0
    var min = 1000001
    var max = -1000001
    var sum: BigInt = 0
    while(i < n) {
      val v = sc.nextInt()

      if (min > v) min = v
      if (max < v) max = v
      sum += v
      i += 1
    }
    println("%d %d %d".format(min, max, sum))

  }
}
