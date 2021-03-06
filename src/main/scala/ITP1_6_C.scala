import java.util.Scanner

object ITP1_6_C {

  def createAptArray(): Array[Array[Array[Int]]] = Array.fill(4, 3, 10)(0)

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val n = sc.nextInt()

    val AptArray = createAptArray()
    val separate ="\n" +  (1 to 20).map(_ => "#").mkString("") + "\n"

    for (_ <- 1 to n) {
      val b = sc.nextInt()
      val f = sc.nextInt()
      val r = sc.nextInt()
      val v = sc.nextInt()

      AptArray(b - 1)(f - 1)(r - 1) += v
    }

    val AptMap = AptArray.map { building =>
      building.map{ floor =>
        floor.map(v => " " + v).mkString
      }.mkString("\n")
    }.mkString(separate)

    println(AptMap)
  }
}
