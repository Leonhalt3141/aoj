
import java.util.Scanner

object ITP1_5_D {

  def checkValue(value: Int): Boolean = (value) match {
    case a if a % 3 == 0 => true
    case b if b.toString.contains("3") => true
    case _ => false
  }

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)

    val n = sc.nextInt

    for (v <- Range(3, n+1)) {
      if (checkValue(v)) print(v + " ")
    }

  }
}
