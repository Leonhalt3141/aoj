
import scala.io.StdIn

object ALDS1_1_D {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    var maxV = Int.MinValue
    var minV = StdIn.readInt()

    (1 until n).foreach { _ =>
      val R = StdIn.readInt()
      if (maxV < R - minV) maxV = R - minV
      if (minV > R ) minV = R

    }
    println(maxV)
  }
}
