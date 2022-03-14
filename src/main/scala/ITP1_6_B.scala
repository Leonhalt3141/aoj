
import java.util.Scanner

object ITP1_6_B {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val n = sc.nextInt()

    val taroCards = (1 to n).map {_ =>
      val cardType = sc.next()
      val cardNumber = sc.nextInt()

      val typeIndex = cardType match {
        case a if a == "S" => 0
        case b if b == "H" => 1
        case c if c == "C" => 2
        case d if d == "D" => 3
      }
      (typeIndex, cardNumber)
    }

    val taroArray: Array[Array[Boolean]] = Array.fill(4, 13)(true)

    for (picked <- taroCards) {
      taroArray(picked._1)(picked._2 - 1) = false
    }

    for (typeIndex <- 0 to 3) {

      val cardType = typeIndex match {
        case s if s == 0 => "S"
        case h if h == 1 => "H"
        case c if c == 2 => "C"
        case d if d == 3 => "D"
      }

      val cards = taroArray(typeIndex)
      cards.zipWithIndex
        .filter(pair => pair._1)
        .map(pair => pair._2 + 1)
        .foreach(v => println(cardType + " " + v))
    }
  }

}
