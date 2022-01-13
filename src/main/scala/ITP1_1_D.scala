
import java.util.Scanner

object ITP1_1_D {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val S = sc.nextInt()

    val second = S % 60

    val minute = S / 60 % 60

    val hour = S / 60 / 60

    println(hour + ":" + minute + ":" + second)
  }
}
