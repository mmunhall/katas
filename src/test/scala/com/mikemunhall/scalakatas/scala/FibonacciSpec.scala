package scala.com.mikemunhall.scalakatas.scala

import org.scalatest.{FlatSpec, Matchers}

class FibonacciSpec extends FlatSpec with Matchers {

  "Fibonacci" should "return fibonacci up to max" in {
    an [IllegalArgumentException] should be thrownBy Fibonacci.getResult(-1)
    Fibonacci.getResult(0) shouldBe Nil
    Fibonacci.getResult(1) shouldBe List(1)
    Fibonacci.getResult(2) shouldBe List(1, 1)
    Fibonacci.getResult(3) shouldBe List(1, 1, 2)
    Fibonacci.getResult(4) shouldBe List(1, 1, 2, 3)
    Fibonacci.getResult(5) shouldBe List(1, 1, 2, 3, 5)
    Fibonacci.getResult(6) shouldBe List(1, 1, 2, 3, 5, 8)
    Fibonacci.getResult(7) shouldBe List(1, 1, 2, 3, 5, 8, 13)
    Fibonacci.getResult(8) shouldBe List(1, 1, 2, 3, 5, 8, 13, 21)
    Fibonacci.getResult(9) shouldBe List(1, 1, 2, 3, 5, 8, 13, 21, 34)
    Fibonacci.getResult(10) shouldBe List(1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
  }
}
