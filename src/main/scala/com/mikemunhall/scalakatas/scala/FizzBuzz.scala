package scala.com.mikemunhall.scalakatas.scala

object FizzBuzz {

  /*def getResult(in: Int): String = {
    in match {
      case x if in % 15 == 0 => "fizzbuzz"
      case x if in % 3 == 0 => "fizz"
      case x if in % 5 == 0 => "buzz"
      case other => other.toString()
    }
  }*/

  def getResult(divisorA: Int, divisorB: Int)(testNum: Int): String = {
    (testNum % divisorA, testNum % divisorB) match {
      case (0, 0) => "fizzbuzz"
      case (0, _) => "fizz"
      case (_, 0) => "buzz"
      case (_, _) => testNum.toString
    }
  }
}
