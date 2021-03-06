object ITP1_7_B {

  def combination(n: Int, x: Int): Int = {
    var count = 0
    for (i <- 1 to n) {
      for (j <- i + 1 to n) {
        for (k <- j + 1 to n) {
          if (i + j + k == x) count += 1
        }
      }
    }
    count
  }

  def main(args: Array[String]): Unit = {
    try {
      for (line <- io.Source.stdin.getLines() if line != "0 0") {
        val Array(n, x) = line.split(" ").map(_.toInt)
        println(combination(n, x))
      }
    } catch {
      case _: Exception => ()
    }
  }
}
