
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object ALDS1_2_D {

  var cnt = 0

  def generateG(n: Int): ArrayBuffer[Int] = {
    val G = ArrayBuffer(1)
    (0 to 100).foreach {i =>
      if (n < 1 + 3 * G.last) {
        return G
      }
      G += 1 + 3 * G.last
    }
    G
  }

  def insertionSort(A: Array[Int], n: Int, g: Int): Unit = {
    (g until n).foreach {i =>
      val v = A(i)
      var j = i - g

      while (j >= 0 && A(j) > v) {
        A(j + g) = A(j)
        j = j - g
        cnt += 1
      }
      A(j + g) = v
    }
  }

  def shellSort(A: Array[Int], n: Int): ArrayBuffer[Int] = {
    val G = generateG(n).reverse
    val m = G.length

    (0 until m).foreach {i =>
      insertionSort(A, n, G(i))
    }
    G
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val A = Array.fill[Int](n)(StdIn.readInt())
    val G = shellSort(A, n)

    println(G.length)
    println(G.mkString(" "))
    println(cnt)
    A.foreach(println)
  }
}
