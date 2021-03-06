import scala.io.StdIn

object ITP1_9_B {

  def rec(): Unit = {
    StdIn.readLine() match {
      case "-" => ()
      case str => {
        println(
          (1 to StdIn.readInt())
            .map(_ => StdIn.readInt())
            .foldLeft(str)((str, h) => {
              str.substring(h) + str.substring(0, h)
            })
        )
        rec()
      }
    }
  }

  def main(args: Array[String]): Unit = { rec() }

//  val IsInt = "^([+-]?\\d+)$".r
//
//  def shuffle(cards: String, index: Int): String = {
//    cards.drop(index) + cards.take(index)
//  }
//
//  def readLines(): List[Any] = {
//    StdIn.readLine() match {
//      case "-" => Nil
//      case IsInt(integer) => integer.toInt :: readLines()
//      case string: String => string :: readLines()
//    }
//  }
//
//  def main(args: Array[String]): Unit = {
//    val reads = readLines()
//    var cardDeck = Array[String]()
//
//    val cardIndex = reads.indices.filter(index => reads(index).isInstanceOf[String])
//
//    for (index <- cardIndex) {
//      var cards = reads(index).toString
//      val shuffleTimes = reads(index + 1)
//      val shuffleNumbers = reads.slice(index + 2, index + 2 + shuffleTimes.toString.toInt)
//
//      for (shuffleIndex <- shuffleNumbers) {
//        cards = shuffle(cards, shuffleIndex.toString.toInt)
//      }
//
//      cardDeck = cardDeck :+ cards
//
//    }
//
//    println(cardDeck.mkString("\n"))
//  }
}
