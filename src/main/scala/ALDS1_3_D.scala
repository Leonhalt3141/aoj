
import scala.annotation.tailrec
import scala.io.StdIn

object ALDS1_3_D {


  @tailrec
  def checkDownhill(strList: List[String], count: Int, hillStack: List[Int], areaStack: List[(Int, Int)]): List[Int] = {
    strList match {
      case Nil => areaStack.map(_._2).reverse
      case "_" :: restList => checkDownhill(restList, count + 1, hillStack, areaStack)
      case "\\" :: restList => checkDownhill(restList, count + 1, count :: hillStack, areaStack)
      case "/" :: restList => {
        hillStack match {
          case Nil => checkDownhill(restList, count + 1, hillStack, areaStack)
          case start :: rest => {
            checkDownhill(restList, count + 1, rest, calculateArea(areaStack, start, count - start))
          }
        }
      }
      case _ :: restList => checkDownhill(restList, count, hillStack, areaStack)
    }
  }

  @tailrec
  def calculateArea(ret: List[(Int, Int)], start: Int, area: Int): List[(Int, Int)] = {
    ret match {
      case Nil => (start, area) :: ret
      case (prevStart, prevArea) :: rest => if (start < prevStart) calculateArea(rest, start, prevArea + area) else (start, area) :: ret
    }
  }

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("").toList
    val areas = checkDownhill(line, 0, Nil, Nil)

    checkDownhill(line, 0, Nil, Nil)
    println(areas.sum)
    if (areas == Nil) {
      println(areas.length)
    } else {
      println(areas.length + " " + areas.mkString(" "))
    }
  }

}

