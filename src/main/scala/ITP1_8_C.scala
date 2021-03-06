
import scala.io.StdIn
import scala.io.Source.stdin

object ITP1_8_C {

  def readLines(): List[String] = {
    Option(StdIn.readLine()) match {
      case None      => Nil
      case Some(str) => str :: readLines()
    }
  }

  def main(args: Array[String]): Unit = {
    val alphabets = ('a' to 'z')
    val counts = Array.fill(alphabets.size)(0)

//    val lines = readLines()
    val lines = stdin.getLines()
    val characters = lines.mkString
    for (char <- characters) {

      if (char.isLetter) {
        val index = alphabets.indexOf(char.toLower)
        counts(index) += 1
      }
    }

    alphabets.zip(counts).foreach(iter => println(iter._1 + " : " + iter._2))

  }
}
