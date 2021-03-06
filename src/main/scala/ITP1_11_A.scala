
import scala.io.StdIn

object ITP1_11_A {
  case class Dice(side1: Int, side2: Int, side3: Int, side4: Int, side5: Int, side6: Int)

  def roll(dice: Dice, direction: String): Dice = {
    direction match {
      case "N" => Dice(dice.side2, dice.side6, dice.side3, dice.side4, dice.side1, dice.side5)
      case "S" => Dice(dice.side5, dice.side1, dice.side3, dice.side4, dice.side6, dice.side2)
      case "E" => Dice(dice.side4, dice.side2, dice.side1, dice.side6, dice.side5, dice.side3)
      case "W" => Dice(dice.side3, dice.side2, dice.side6, dice.side1, dice.side5, dice.side4)
    }
  }

  def main(args: Array[String]): Unit = {
    val values = StdIn.readLine().split(" ").map(_.toInt)
    val operations = StdIn.readLine()

    val dice = Dice(values(0), values(1), values(2), values(3), values(4), values(5))

    println(operations.split("").foldLeft(dice)(roll).side1)
  }
}
