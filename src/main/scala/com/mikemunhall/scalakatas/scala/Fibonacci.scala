package scala.com.mikemunhall.scalakatas.scala

object Fibonacci {

  def getResult(max: Int, acc: List[Int] = Nil): List[Int] = {

    if (max < 0) {
      throw new IllegalArgumentException
    } else if (max == 0) {
      acc
    } else if (max == 1) {
      List(1)
    } else if (acc == Nil) {
      getResult(max, List(1, 1))
    } else if (acc.size >= max) {
      acc.reverse
    } else {
      getResult(max, acc.head + acc.tail.head :: acc)
    }

  }
}
