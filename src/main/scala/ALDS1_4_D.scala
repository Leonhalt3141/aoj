
import scala.annotation.tailrec
import scala.io.StdIn

object ALDS1_4_D {
  def main(args: Array[String]): Unit = {
    // n: 荷物の数
    // k: トラックの数
    val Array(n, k) = StdIn.readLine().split(" ").map(_.toInt)

    // ws: 核荷物の重さ
    val ws = List.fill(n)(StdIn.readLong())

    val solver = new Solver(ws, k, n)

    val p = solver.solve
    println(p)

  }
}


class Solver(packages: List[Long], truckNum: Int, allPackageNum: Int) {

  def solve: Long = {
    import BinarySearch.binarySearch

    //  答えとなりうる値の最小値
    val minL = packages.max

    // 答えとなりうる値の最大値
    val maxR = minL * allPackageNum

    // canLoadByを判定関数pとする
    // minLは探索範囲の左端、maxRは探索範囲の右端
    // バイナリーサーチを使って、minLからmaxRの範囲で最大積載量pを探索する
    binarySearch(minL, maxR)(canLoadBy).get
  }

  /**
   *
   * @param p 最大積載量
   * @return  全ての荷物を運ぶことができるのならtrueを返す
   */
  def canLoadBy(p: Long): Boolean = {
    import Implicits.ListOps

    /**
     * 引数がList[Long]で(Long, List[Long])を返す
     * _ + _ : 集約演算
     * _ <= p : 処理を続けるかどうかを判定する条件. 合計値がp以下かどうか。
     */
    val loadPackages: List[Long] => (Long, List[Long]) = _.reduceWhile{ _ + _}(_ <= p)

    @tailrec
    def go(restPackages: List[Long], restTrucksNum: Int): Boolean = {
      //  残りが空になり、全ての荷物を運ぶことができた
      if (restPackages.isEmpty) true
      //  トラックの残数がゼロとなり、全ての荷物を運ぶことができなかった
      else if (restTrucksNum == 0) false
      else {
        val (_, newRestPackages) = loadPackages(restPackages)

        //  荷物を1台のトラックに条件通りに積載できたので、次のトラックへの積載を試みる
        go(newRestPackages, restTrucksNum - 1)
      }
    }
    go(packages, truckNum)
  }

}

object BinarySearch {

  /**
   *
   * @param left  探索範囲の左端
   * @param right 探索範囲の右端
   * @param p  中間値が探索範囲内かどうかを判定する関数（集約値が最大積載量以下かどうか）
   * @param num  取り扱う任意のデータ型に対応（演算）するためのオブジェクト？ Integralは数値型を拡張する
   * @tparam A  取り扱うデータ型
   * @return  探索範囲内に条件を満たす値があればその最小値を返す。なければNoneを返す
   */
  def binarySearch[A](left: A, right: A)(p: A => Boolean)(implicit num: Integral[A]): Option[A] = {
    import num._

    val one = num.one
    val two = num.fromInt(2)

    @tailrec
    def go(l: A, r: A): A = {
      //  探索範囲の左端が右端より大きかった場合、右を返す
      if (l >= r) r
      else {

        //  探索範囲の真ん中の要素を計算
        val mid = (l + r) / two

        //  真ん中の要素が条件に合う場合、右端を真ん中とし、再探索
        //  条件に合わなかった場合、真ん中の次の要素を左端とし、再探索
        if (p(mid)) go(l, mid)
        else go(mid + one, r)
      }
    }
    //  左端が右端よりも大きい、もしくは右端の値が条件に合わなかった場合、Noneを返す
    //  それ以外は探索を行う
    if (left > right || !p(right)) None
    else Some(go(left, right))

  }
}


object Implicits {

  /**
   * implicitによって暗黙の型変換機能の定義が可能になる
   * @param self  自身を表すList
   * @tparam A  要素の型
   */
  implicit class ListOps[A](self: List[A]) {

    /**
     * 条件を満たし続ける限りListの要素を集約する
     * 条件を満たさなくなった時点で処理を打ち切る
     * @param z  初期値
     * @param op  集約演算の関数
     * @param p  処理を続けるかどうかを判定する述語関数
     * @tparam B  処理した要素の型
     * @return  条件を満たさなくなった時点のそれまでの計算結果と残りのListの組合せ
     */
    def foldWhile[B](z: B)(op: (B, A) => B)(p: B => Boolean): (B, List[A]) = {

      @tailrec
      def go(zs: List[A], accum: B): (B, List[A]) = zs match {
        // 処理を最後まで行ったので、集約値を返す
        case Nil => (accum, Nil)
        // 条件を満たした場合、末尾のListに対して、前要素までの集約値とともに再帰処理を行う
        // 条件を満たさなかった場合、集約値と処理するListを返す
        case x :: xs =>
          //  積算値と配列の最前の値を集約する（足し合わせる）
          val s = op(accum, x)
          //  集約値が条件を満たす場合、残りの配列と集約値を自身の関数の引数とし、再帰処理
          //  集約値が条件を満たさなかった場合、引数を返す
          if (p(s)) go(xs, s) else (accum, zs)
      }
      go(self, z)
    }

    /**
     *
     * @param op  集約演算の関数
     * @param p  処理を続けるかどうかを判定する述語関数
     * @return
     */
    def reduceWhile(op: (A, A) => A)(p: A => Boolean): (A, List[A]) =
      self.tail.foldWhile(self.head)(op)(p)
  }
}
