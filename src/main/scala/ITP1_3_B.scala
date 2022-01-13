
object ITP1_3_B {
  def main(args: Array[String]): Unit = {
    var i = 1

    for (line <- io.Source.stdin.getLines() if line != "0") {
      val x = line.toInt
      println("Case " + i + ": " + x)
      i += 1
    }

  }
}
