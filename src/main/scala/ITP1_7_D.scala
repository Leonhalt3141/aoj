
import java.util.Scanner

object ITP1_7_D {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val n, m, l = sc.nextInt()
    val MatrixA: Array[Array[Long]] = Array.fill(n, m)(sc.nextInt())
    val MatrixB: Array[Array[Long]] = Array.fill(m, l)(sc.nextInt())
    val MatrixC = Array.fill[Long](n, l)(0)

//    for (i <- 0 until  n) {
//      val VectorA = MatrixA(i)
//      for (j <- 0 until  l) {
//        val VectorB = MatrixB.map(v => v(j))
//        MatrixC(i)(j) = VectorA.zip(VectorB).map(pair => pair._1 * pair._2).sum
//      }
//      println(MatrixC(i).mkString(" "))
//    }

    for (i <- 0 until n; j <- 0 until l; k <- 0 until m) {
      MatrixC(i)(j) += MatrixA(i)(k) * MatrixB(k)(j)
    }
    MatrixC.foreach(vector => println(vector.mkString(" ")))
  }
}
