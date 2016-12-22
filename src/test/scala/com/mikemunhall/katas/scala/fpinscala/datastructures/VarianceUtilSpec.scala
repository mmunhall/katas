package com.mikemunhall.katas.scala.fpinscala.datastructures

import org.scalatest.{FlatSpec, Matchers}

class VarianceUtilSpec extends FlatSpec with Matchers {

  VarianceUtil.variance(scala.collection.immutable.List(0.0, 0.0, 0.0)) shouldBe Some(0.0)
  VarianceUtil.variance(scala.collection.immutable.List(1.0, 1.0, 1.0)) shouldBe Some(0.0)
  VarianceUtil.variance(scala.collection.immutable.List(10.0, 20.0, 30.0, 40.0)) shouldBe Some(125.0)
  VarianceUtil.variance(scala.collection.immutable.List()) shouldBe None

}
