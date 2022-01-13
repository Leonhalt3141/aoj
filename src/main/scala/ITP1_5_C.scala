object ITP1_5_C {

  def draw(H: Int, W: Int): Unit = {
    for (y <- Range(0, H)) {
      y match {
        case x if x % 2 == 0 => println(List.range(0, W).map(v => if (v % 2 == 0) "#" else ".").mkString)
        case x if x % 2 == 1 => println(List.range(0, W).map(v => if (v % 2 == 0) "." else "#").mkString)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    try{
      for (line <- io.Source.stdin.getLines() if line != "0 0") {
        val array = line.split(" ")
        val H = array(0).toInt
        val W = array(1).toInt
        draw(H, W)
        println()
      }
    } catch {
      case _: Exception => println("#")
    }

  }
}
