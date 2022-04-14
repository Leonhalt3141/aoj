
import scala.io.StdIn

object ALDS1_2_C {

  def BubbleSort(Cards: String, n: Int): Array[String] = {
    val C = Cards.split(" ")

    (0 until n).foreach { i =>
      (i + 1 until n).reverse.foreach {j =>
        if (C(j).tail.toInt < C(j - 1).tail.toInt) {
          val temp1 = C(j)
          val temp2 = C(j - 1)

          C(j) = temp2
          C(j - 1) = temp1
        }
      }
    }
    C
  }

  def SelectionSort(Cards: String, n: Int): Array[String] = {
    val C = Cards.split(" ")
    (0 until n).foreach {i =>
      var minj = i

      (i until n).foreach { j =>
        if (C(j).tail.toInt < C(minj).tail.toInt) {
          minj = j
        }
      }
      val temp1 = C(i)
      val temp2 = C(minj)

      C(i) = temp2
      C(minj) = temp1
    }
    C
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val Cards = StdIn.readLine()

    val BubbleCards = BubbleSort(Cards, n).mkString(" ")
    println(BubbleCards)
    println("Stable")

    val SelectionCards = SelectionSort(Cards, n).mkString(" ")
    println(SelectionCards)

    SelectionCards match {
      case BubbleCards => println("Stable")
      case _ => println("Not stable")
    }

  }
}
