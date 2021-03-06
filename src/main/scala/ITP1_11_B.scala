
import scala.annotation.tailrec
import scala.io.StdIn

object ITP1_11_B {

  case class Dice(side1: Int, side2: Int, side3: Int, side4: Int, side5: Int, side6: Int)

  def roll(dice: Dice, direction: String): Dice = {
    direction match {
      case "N" => Dice(dice.side2, dice.side6, dice.side3, dice.side4, dice.side1, dice.side5)
      case "S" => Dice(dice.side5, dice.side1, dice.side3, dice.side4, dice.side6, dice.side2)
      case "E" => Dice(dice.side4, dice.side2, dice.side1, dice.side6, dice.side5, dice.side3)
      case "W" => Dice(dice.side3, dice.side2, dice.side6, dice.side1, dice.side5, dice.side4)
    }
  }

  @tailrec
  def rightRotate(dice: Dice, side1Value: Int, side2Value: Int): Unit = {
    dice match {
      case d if d.side1 == side1Value && d.side2 == side2Value => println(dice.side3)
      case _ => rightRotate(Dice(dice.side1, dice.side4, dice.side2, dice.side5, dice.side3, dice.side6), side1Value, side2Value)
    }
  }

  def main(args: Array[String]): Unit = {
    val values = StdIn.readLine().split(" ").map(_.toInt)
    val questionNum = StdIn.readInt()

    val dice = Dice(values(0), values(1), values(2), values(3), values(4), values(5))

    (1 to questionNum).foreach{_ =>
      val Array(side1Value, side2Value) = StdIn.readLine().split(" ").map(_.toInt)

      val side1Index = values.indexOf(side1Value) + 1

      if (side1Index == 1) {
        rightRotate(dice, side1Value, side2Value)
      } else if (side1Index == 2) {
        rightRotate(roll(dice, "N"), side1Value, side2Value)
      } else if (side1Index == 3) {
        rightRotate(roll(dice, "W"), side1Value, side2Value)
      } else if (side1Index == 4) {
        rightRotate(roll(dice, "E"), side1Value, side2Value)
      } else if (side1Index == 5) {
        rightRotate(roll(dice, "S"), side1Value, side2Value)
      } else if (side1Index == 6) {
        rightRotate("NN".split("").foldLeft(dice)(roll), side1Value, side2Value)
      }
    }

  }
}
