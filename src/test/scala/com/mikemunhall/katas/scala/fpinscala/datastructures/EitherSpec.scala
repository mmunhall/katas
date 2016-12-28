package scala.com.mikemunhall.katas.scala.fpinscala.datastructures

import org.scalatest.{FlatSpec, Matchers}

class EitherSpec extends FlatSpec with Matchers {

  "Either" should "map" in {
    val r = Right(1)
    val l = Left("not numeric")

    r.map(_.toString) shouldBe Right("1")
    l.map(_.toString) shouldBe Left("not numeric")
  }

  it should "flatMap" in {
    val r = Right(1)
    val l = Left("not numeric")

    r.flatMap(v => Right(v.toString)) shouldBe Right("1")
    l.flatMap(v => Right(v.toString)) shouldBe Left("not numeric")
  }

  it should "orElse" in {
    val r = Right(1)
    val l = Left("not numeric")

    r.orElse(Right(2)) shouldBe Right(1)
    l.orElse(Right(2)) shouldBe Right(2)
  }

}
