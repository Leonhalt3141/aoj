

object ITP1_4_C {
  def calc(a: Int, op: Char, b: Int): Unit = (a, op, b) match {
    case (a, '+', b) => println("%d".format(a + b))
    case (a, '-', b) => println("%d".format(a - b))
    case (a, '*', b) => println("%d".format(a * b))
    case (a, '/', b) => println("%d".format(a / b))
  }

  def main(args: Array[String]): Unit = {
    try {
      for (line <- io.Source.stdin.getLines() if line.split(" ")(1).charAt(0) != '?') {
        val list = line.split(" ")
        val a = list(0).toInt
        val op = list(1).charAt(0)
        val b = list(2).toInt
        calc(a, op, b)
      }
    } catch {
      case _: Exception => ()
    }

  }
}
