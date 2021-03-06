
import scala.io.StdIn

object ITP1_9_C {
  def main(args: Array[String]): Unit = {

    val battleTimes = StdIn.readInt()
    val points = Array.fill[Int](2)(0)

    for (_ <- 1 to battleTimes) {
      val line = StdIn.readLine().split(" ")
      val taro = line.head.mkString
      val hanako = line.tail.mkString

      if (taro == hanako) {
        points(0) += 1
        points(1) += 1
      }
      if (taro > hanako) points(0) += 3
      if (taro < hanako) points(1) += 3

    }
    println(points.mkString(" "))
  }

}
