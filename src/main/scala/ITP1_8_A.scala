

object ITP1_8_A {

  def convert(s: Char): Char = s match {
    case s => if (s.isUpper) s.toLower else s.toUpper
  }

  def main(args: Array[String]): Unit = {

    val line = scala.io.StdIn.readLine()
    line.foreach(s => print(convert(s)))
    println("")
  }
}
