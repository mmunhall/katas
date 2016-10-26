package com.mikemunhall.katas.scala

import org.scalatest.{FlatSpec, Matchers}

class HigherOrderFnSpec extends FlatSpec with Matchers {

  "HigherOrderFn with x=>x" should "return x" in {
    HigherOrderFn.getResult(x=>x, 1, 5) shouldBe 5
    HigherOrderFn.getResult(x=>x, 1, 10) shouldBe 10
    HigherOrderFn.getResult(x=>x, 1, 25) shouldBe 25
  }

  "HigherOrderFn with x=>x*x" should "return x*x" in {
    HigherOrderFn.getResult(x=>x*x, 1, 10) shouldBe 100
    HigherOrderFn.getResult(x=>x*x, 1, 5) shouldBe 25
    HigherOrderFn.getResult(x=>x*x, 1, 25) shouldBe 625
  }

}
