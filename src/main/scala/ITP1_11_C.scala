
import scala.io.StdIn
import scala.annotation.tailrec

object ITP1_11_C {

  case class Dice(side1: Int, side2: Int, side3: Int, side4: Int, side5: Int, side6: Int)


  def roll(dice: Dice, direction: String): Dice = {
    direction match {
      case "N" => Dice(dice.side2, dice.side6, dice.side3, dice.side4, dice.side1, dice.side5)
      case "S" => Dice(dice.side5, dice.side1, dice.side3, dice.side4, dice.side6, dice.side2)
      case "E" => Dice(dice.side4, dice.side2, dice.side1, dice.side6, dice.side5, dice.side3)
      case "W" => Dice(dice.side3, dice.side2, dice.side6, dice.side1, dice.side5, dice.side4)
    }
  }

  def rollUpDice(dice: Dice, side1Index: Int): Dice = {
    if (side1Index == 2) {
      roll(dice, "N")
    } else if (side1Index == 3) {
      roll(dice, "W")
    } else if (side1Index == 4) {
      roll(dice, "E")
    } else if (side1Index == 5) {
      roll(dice, "S")
    } else "NN".split("").foldLeft(dice)(roll)
  }

  @tailrec
  def rightRotate(dice: Dice, side1Value: Int, side2Value: Int): Dice = {
    dice match {
      case d if d.side1 == side1Value && d.side2 == side2Value => d
      case _ => rightRotate(Dice(dice.side1, dice.side4, dice.side2, dice.side5, dice.side3, dice.side6), side1Value, side2Value)
    }
  }

  def identicalDices(dice1: Dice, dice2: Dice): Boolean = {
    if (dice1.side1 == dice2.side1 & dice1.side2 == dice2.side2 & dice1.side3 == dice2.side3 &
      dice1.side4 == dice2.side4 & dice1.side5 == dice2.side5) {
      true
    } else false
  }

  def checkDices(dice1: Dice, dice2: Dice): Boolean = {
    if (dice1.side6 == dice2.side6) {
      val rotatedDice2 = rightRotate(dice2, dice1.side1, dice1.side2)
      return identicalDices(dice1, rotatedDice2)
    }
    false
  }

  def checkAllDirections(dice1: Dice, dice2: Dice, indexArray: Array[Int]): Boolean = {
    for (index <- indexArray) {
      if (index == 1) {
        if (checkDices(dice1, dice2)) return true
      } else {
        if (checkDices(dice1, rollUpDice(dice2, index))) return true
      }
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val values1 = StdIn.readLine().split(" ").map(_.toInt)
    val dice1 = Dice(values1(0), values1(1), values1(2), values1(3), values1(4), values1(5))

    val values2 = StdIn.readLine().split(" ").map(_.toInt)
    val dice2 = Dice(values2(0), values2(1), values2(2), values2(3), values2(4), values2(5))

    val Dice2IndexDice1ValueArray = values2.zipWithIndex.filter(pair => pair._1 == dice1.side1).map(pair => pair._2 + 1)

    if (checkAllDirections(dice1, dice2, Dice2IndexDice1ValueArray)) println("Yes")
    else println("No")

  }
}
