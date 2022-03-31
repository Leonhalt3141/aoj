
import java.util.Scanner

object ITP1_9_A {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val word = sc.next()

    var T = ""
    var count = 0
    var read = true

    while (read) {
      T = sc.next()
      if (T == "END_OF_TEXT") {
        read = false
      } else if (T.toLowerCase == word) count += 1

    }

    println(count)
  }
}
