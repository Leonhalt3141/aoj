
import scala.io.StdIn

object ITP1_9_D {

  def replace(str: String, a: Int, b: Int, p: String): String = {
    str.take(a) + p + str.drop(b + 1)

  }

  def reverse(str: String, a: Int, b: Int): String = {
    str.take(a) + str.slice(a, b+1).reverse + str.drop(b + 1)
  }

  def print(str: String, a: Int, b: Int): String = {
    println(str.slice(a, b + 1))

    str
  }

  def main(args: Array[String]): Unit = {
    val str = StdIn.readLine()

    val processNumber = StdIn.readInt()

    (1 to processNumber)
      .map(_ => StdIn.readLine())
      .foldLeft(str)((str, line) =>{
        val commandArray = line.split(" ")
        val function = commandArray(0)
        function match {
          case "replace" => replace(str, commandArray(1).toInt, commandArray(2).toInt, commandArray(3))
          case "reverse" => reverse(str, commandArray(1).toInt, commandArray(2).toInt)
          case "print" => print(str, commandArray(1).toInt, commandArray(2).toInt)
        }
      })

    }
}
