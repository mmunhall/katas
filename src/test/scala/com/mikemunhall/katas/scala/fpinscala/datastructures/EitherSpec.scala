package scala.com.mikemunhall.katas.scala.fpinscala.datastructures

import org.scalatest.{FlatSpec, Matchers}

class EitherSpec extends FlatSpec with Matchers {

  "either" should "map" in {
    val r = Right(1)
    val l = Left("not numeric")

    r.map(_.toString) shouldBe Right("1")
    l.map(_.toString) shouldBe Left("not numeric")
  }

  "either" should "flatMap" in {
    val r = Right(1)
    val l = Left("not numeric")

    r.flatMap(v => Right(v.toString)) shouldBe Right("1")
    l.flatMap(v => Right(v.toString)) shouldBe Left("not numeric")
  }

}
