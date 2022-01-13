object ITP1_3_C {
  def main(args: Array[String]): Unit = {
    for (line <- io.Source.stdin.getLines() if line != "0 0") {
      val array = line.split(" ").map(_.toInt).sorted
      println(array.mkString(" "))
    }
  }
}
