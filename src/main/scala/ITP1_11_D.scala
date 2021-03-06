
import scala.io.StdIn
import scala.annotation.tailrec

object ITP1_11_D {
  case class Dice(side1: Int, side2: Int, side3: Int, side4: Int, side5: Int, side6: Int)
  case class DiceCombination(dice1: Dice, dice2: Dice)

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

  def checkNumbers(dice1: Dice, dice2: Dice): Boolean = {
    val values1 = Array(dice1.side1, dice1.side2, dice1.side3, dice1.side4, dice1.side5, dice1.side6).distinct
    val values2 = Array(dice2.side1, dice2.side2, dice2.side3, dice2.side4, dice2.side5, dice2.side6).distinct

    values1.foreach { value =>
      if (values2.indexOf(value) == -1) return false
    }

    values2.foreach { value =>
      if (values1.indexOf(value) == -1) return false
    }
    true
  }

  def checkCombinations(combinations: List[DiceCombination]): Boolean = {
    combinations.foreach {combination =>
      val dice1 = combination.dice1
      val dice2 = combination.dice2

      if (checkNumbers(dice1, dice2)) {
        val values2 = Array(dice2.side1, dice2.side2, dice2.side3, dice2.side4, dice2.side5, dice2.side6)
        val Dice2IndexDice1ValueArray = values2.zipWithIndex.filter(pair => pair._1 == dice1.side1).map(pair => pair._2 + 1)
        if (checkAllDirections(dice1, dice2, Dice2IndexDice1ValueArray)) return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val diceNumber = StdIn.readInt()

    val dices = (1 to diceNumber).map { _ =>
      val values = StdIn.readLine().split(" ").map(_.toInt)
      Dice(values(0), values(1), values(2), values(3), values(4), values(5))
    }

    val diceCombinations = dices.combinations(2).map(comb => DiceCombination(comb(0), comb(1))).toList
    if (checkCombinations(diceCombinations)) println("Yes")
    else println("No")
  }

}
