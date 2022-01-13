
object ITP1_5_B {

  def draw(H: Int, W: Int): Unit = {
    val internal_H = H - 1
    for (y <- Range(0, H)) {
      y match {
        case 0 => println(List.range(0, W).map(_ => "#").mkString)
        case x if internal_H > x => println("#" + List.range(0, W - 2).map(_ => ".").mkString + "#")
        case x if internal_H == x => println(List.range(0, W).map(_ => "#").mkString)
      }
    }
  }

  def main(args: Array[String]): Unit = {

    try {
      for (line <- io.Source.stdin.getLines() if line != "0 0") {
        val array = line.split(" ")
        val H = array(0).toInt
        val W = array(1).toInt

        draw(H, W)
        println()
      }
    } catch {
      case _: Exception => ()
    }

  }
}
