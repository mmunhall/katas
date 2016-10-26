package com.mikemunhall.katas.scala

import org.scalatest.{FlatSpec, Matchers}

class CurryingSpec extends FlatSpec with Matchers {

  "curried functions" should "take a tuple of arguments in such a way that it can be called as a chain of functions" in {
    Currying.getResult2(10)(20) should be (30)
    Currying.getResult2(-5)(5) should be (0)
    Currying.getResult2(0)(300) should be (300)

    Currying.getResult3(10)(20)(5) should be (35)
    Currying.getResult3(-5)(5)(5) should be (5)
    Currying.getResult3(0)(300)(5) should be (305)
  }
}
