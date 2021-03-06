
import java.util.Scanner

object ITP1_6_D {
  def main(args: Array[String]): Unit = {

    val sc = new Scanner(System.in)

    val n, m = sc.nextInt()

    val MatrixA: Array[Array[Int]] = Array.fill(n, m)(sc.nextInt())
    val VectorB: Array[Int] = Array.fill(m)(sc.nextInt())

    MatrixA.map {A =>
      A.zip(VectorB).map {x =>
        x._1 * x._2
      }.sum
    }.foreach(println)
  }
}
