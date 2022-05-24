
import scala.io.StdIn

object ALDS1_4_C {

  private var dictionary = Set[String]("")

  def operation(opt: String, str: String): Unit = {
    if (opt == "insert") {
      dictionary = dictionary + str
    }

    if (opt == "find") {
      if (dictionary.contains(str)) println("yes")
      else println("no")
    }
  }


  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    (0 until n).foreach {_ =>
      val Array(opt, str) = StdIn.readLine().split(" ")
      operation(opt, str)
    }
  }
}
