package com.mikemunhall.katas.scala.fpinscala.datastructures

import org.scalatest.{FlatSpec, Matchers}

class OptionSpec extends FlatSpec with Matchers {

  "Option" should "do all the things" in {

    Some(2.0).map(_.toString) shouldBe Some("2.0")
    None.map(_.toString) shouldBe None

    Some(2.0).flatMapMatcher(a => Some(a.toString)) shouldBe Some("2.0")
    None.flatMapMatcher(a => Some(a.toString)) shouldBe None

    Some(2.0).flatMap(a => Some(a.toString)) shouldBe Some("2.0")
    None.flatMap(a => Some(a.toString)) shouldBe None

    Some(2.0).getOrElse(3.0) shouldBe 2.0
    None.getOrElse(3.0) shouldBe 3.0

    Some(2.0).orElseMatcher(Some(3.0)) shouldBe Some(2.0)
    None.orElseMatcher(Some(3.0)) shouldBe Some(3.0)

    Some(2.0).orElse(Some(3.0)) shouldBe Some(2.0)
    None.orElse(Some(3.0)) shouldBe Some(3.0)

    Some(2.0).filterMatcher(_ > 1.0) shouldBe Some(2.0)
    Some(2.0).filterMatcher(_ < 1.0) shouldBe None
    None.filterMatcher((a: Double) => a < 2.0) shouldBe None

    Some(2.0).filter(_ > 1.0) shouldBe Some(2.0)
    Some(2.0).filter(_ < 1.0) shouldBe None
    None.filter((a: Double) => a < 2.0) shouldBe None

    Some(1).map(a => Some(a + 1)) shouldBe Some(Some(2))
    Some(1).flatMap(a => Some(a + 1)) shouldBe Some(2)
  }

}
