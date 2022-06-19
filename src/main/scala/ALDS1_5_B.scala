
import java.util.Scanner
import scala.annotation.tailrec
import scala.io.StdIn

object ALDS1_5_B {

  var num = 0

  @tailrec
  def merge(seq1: List[Int], seq2: List[Int], accumulator: List[Int] = List()):List[Int] = (seq1, seq2) match {
    case (Nil, _) =>
      accumulator ++ seq2
    case (_, Nil) => accumulator ++ seq1
    case (x::xs, y::ys) =>
      num += 1
      if(x<y) merge(xs,seq2, accumulator :+ x)
      else merge(seq1,ys, accumulator :+ y)
  }

  def mergeSort(seq: List[Int]): List[Int] = seq match {
    case Nil => Nil
    case xs::Nil =>
      num += 1
      List(xs)
    case _ =>
//      num += 2
      val (left, right) = seq.splitAt(seq.length / 2)
      merge(mergeSort(left), mergeSort(right))
  }

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val n = sc.nextInt()
    val A = List.fill(n)(sc.nextInt())

    val sortedA = mergeSort(A)
    println(sortedA.mkString(" "))
    println(num)
  }

}
