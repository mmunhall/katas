package scala.com.mikemunhall.scalakatas.scala

import org.scalatest.{FlatSpec, Matchers}

class FactorialSpec extends FlatSpec with Matchers {

  "Factorial" should "return n!" in {
    Factorial.getResult(0) shouldBe 1
    Factorial.getResult(1) shouldBe 1
    Factorial.getResult(2) shouldBe 2
    Factorial.getResult(3) shouldBe 6
    Factorial.getResult(4) shouldBe 24
    Factorial.getResult(5) shouldBe 120
    Factorial.getResult(6) shouldBe 720
    Factorial.getResult(7) shouldBe 5040
  }

  it should "throw IllegalArgumentException for negative numbers" in {
    an [IllegalArgumentException] should be thrownBy Factorial.getResult(-1)
  }
}
