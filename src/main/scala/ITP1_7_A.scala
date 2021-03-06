

object ITP1_7_A {
  def main(args: Array[String]): Unit = {

    def grade(m: Int, f: Int, r: Int): String = (m, f, r) match {
      case (-1, -1, _) => "F"
      case (-1, _, _) => "F"
      case (_, -1, _) => "F"
      case (b1, b2, _) if (b1 + b2) < 30 => "F"
      case (c1, c2, c3) if (c1 + c2) < 50 => if (c3 >= 50) "C" else "D"
      case (d1, d2, _) if (d1 + d2) < 65 => "C"
      case (e1, e2, _) if (e1 + e2) < 80 => "B"
      case (f1, f2, _) if (f1 + f2) >= 80 => "A"
    }

    try{
      for (line <- io.Source.stdin.getLines() if line != "-1 -1 -1") {
        val Array(m, f, r) = line.split(" ").map(_.toInt)
        println(grade(m, f, r))
      }
    } catch {
      case _: Exception => ()
    }
  }
}
