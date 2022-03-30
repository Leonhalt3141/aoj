
import scala.io.StdIn

object ITP1_8_D {
  def main(args: Array[String]): Unit = {

    val characters = StdIn.readLine()
    val word = StdIn.readLine()

    val loop = characters ++ characters.take(characters.length - 1)

    if (loop.contains(word)) {
      println("Yes")
    } else println("No")

  }
}
