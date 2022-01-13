
object ITP1_5_A {

  def draw(H: Int, W: Int): Unit = {
    for(_ <- Range(0, H)) {
      List.range(0, W).foreach(_ => print("#"))
      println("")
    }
  }

  def main(args: Array[String]): Unit = {
    try {
      for (line <- io.Source.stdin.getLines() if line != "0 0") {
        val array = line.split(" ")
        val H = array(0).toInt
        val W = array(1).toInt
        draw(H, W)
        println("")
      }
    } catch {
      case _: Exception => ()
    }


  }
}
