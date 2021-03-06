object ITP1_8_B {
  def main(args: Array[String]): Unit = {
    try {
      for (line <- io.Source.stdin.getLines() if line != "0") {
        val numbers = line.split("").map(_.toInt)
        println(numbers.sum)
      }
    } catch {
      case _: Exception => ()
    }
  }
}
