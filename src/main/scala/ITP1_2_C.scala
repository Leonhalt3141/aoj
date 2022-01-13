
import java.util.Scanner

object ITP1_2_C {

  def merge(left: List[Int], right: List[Int]): List[Int] = (left, right ) match {
    case (left, Nil) => left
    case (Nil, right) => right
    case (leftHead :: leftTails, rightHead :: rightTails) =>
      if (leftHead < rightHead) leftHead::merge(leftTails, right)
      else rightHead :: merge(left, rightTails)
  }

  def mergeSort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case rightHead :: Nil => List(rightHead)
    case _ =>
      val (left, right) = list.splitAt(list.length / 2)
      merge(mergeSort(left), mergeSort(right))
  }

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val a = sc.nextInt()
    val b = sc.nextInt()
    val c = sc.nextInt()

    val list = List(a, b , c)
    val sorted = mergeSort(list)
    println(sorted.mkString(" "))

  }
}
