
import java.util.Scanner
import scala.annotation.tailrec
import scala.io.StdIn

object ALDS1_5_B {

  var num = 0

  def mergeA(A: Array[Int], left: Int, mid: Int, right: Int): Unit = {
    val n1 = mid - left
    val n2 = right - mid

    val l = new Array[Int](n1 + 1)
    val r = new Array[Int](n2 + 1)

    Array.copy(A, left, l, 0, l.length - 1)
    Array.copy(A, mid, r, 0, r.length - 1)

    l(n1) = Int.MaxValue
    r(n2) = Int.MaxValue

    var i = 0
    var j = 0

    for (k <- left until right) {
      num += 1
      if (l(i) <= r(j)) {
        A(k) = l(i)
        i += 1
      } else {
        A(k) = r(j)
        j += 1
      }
    }


  }

  def mergeSortA(A: Array[Int], left: Int, right: Int): Array[Int] = {
    if (left + 1 < right) {
      val mid = (left + right) / 2
      mergeSortA(A, left, mid)
      mergeSortA(A, mid, right)
      mergeA(A, left, mid, right)
    }
    A
  }

  @tailrec
  def merge(seq1: List[Int], seq2: List[Int], accumulator: List[Int] = List()):List[Int] = (seq1, seq2) match {
    case (Nil, _) =>
      num += 1
      accumulator ++ seq2
    case (_, Nil) =>
      num += 1
      accumulator ++ seq1
    case (x :: xs, y :: ys) =>
      num += 1
      println(num + " | " + x + "|" + xs.mkString(" ") + " | " + y + "|" + ys.mkString(" "))
      if(x < y) merge(xs, seq2, accumulator :+ x)
      else merge(seq1, ys, accumulator :+ y)
  }

  def mergeSort(seq: List[Int]): List[Int] = seq match {
    case Nil =>
      num += 1
      Nil
    case xs :: Nil =>
      List(xs)
    case _ =>
      val (left, right) = seq.splitAt(seq.length / 2)
      merge(mergeSort(left), mergeSort(right))
  }

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val n = sc.nextInt()
//    val A = List.fill(n)(sc.nextInt())
    val A = Array.fill(n)(sc.nextInt())

    val sortedA = mergeSortA(A, 0, A.length)
    println(sortedA.mkString(" "))
    println(num)
  }

}
