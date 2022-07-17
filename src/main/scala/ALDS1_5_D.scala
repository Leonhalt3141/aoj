
import scala.io.StdIn

object ALDS1_5_D {

  def bubbleSort(A: Array[Int]): Int = {
    var count = 0
    for (i <- A.indices) {
      for (j <- Range(A.length - 1, i, -1)) {
        if (A(j) < A(j - 1)){
          val temp = A(j)
          A(j) = A(j - 1)
          A(j - 1) = temp
          count += 1
        }
      }
    }
    count
  }

  def mergeSortA(A: Array[Int], n: Int): Long = {
    var count = 0L

    def msort(s: Int, e: Int): Unit = {
      if (e-s > 0) {
        msort(s, (s+e)/2)
        msort((s+e)/2+1, e)
        var i = s
        var j = (s+e)/2+1
        var k = 0
        val tmp = Array.fill(e-s+1)(0)
        var f = true
        while (f)
          if (i > (s+e)/2 && j > e) f = false
          else if (j > e || (i <= (s+e)/2 && A(i) < A(j))) {
            tmp(k) = A(i)
            i += 1
            k += 1
          }
          else {
            tmp(k) = A(j)
            j += 1
            k += 1
            count += ((s+e)/2-i+1)
          }
        tmp.copyToArray(A, s)
      }
    }
    msort(0, n - 1)
    count

  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val A = StdIn.readLine().split(" ").map(_.toInt)

//    println(bubbleSort(A))
    println(mergeSortA(A, n))
  }
}
