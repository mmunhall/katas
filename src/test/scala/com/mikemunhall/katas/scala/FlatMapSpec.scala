package com.mikemunhall.katas.scala

import org.scalatest.{FlatSpec, Matchers}

class FlatMapSpec extends FlatSpec with Matchers {

  "map and flatMap" should "do all the things" in {
    val fruits = List("apple", "orange", "banana")
    val nums = List(0, 1, 2, 3)
    val numLists = List(List(1, 2, 3), List(4, 5), List(6, 7, 8, 9))
    def g(v: Int): List[Int] = List(v - 1, v, v + 1)

    fruits.map(_.toUpperCase) shouldBe List("APPLE", "ORANGE", "BANANA")
    fruits.flatMap(_.toUpperCase) shouldBe List('A', 'P', 'P', 'L', 'E', 'O', 'R', 'A', 'N', 'G', 'E', 'B', 'A', 'N', 'A', 'N', 'A')
    nums.map(g) shouldBe List(List(-1, 0, 1), List(0, 1, 2), List(1, 2, 3), List(2, 3, 4))
    nums.flatMap(g) shouldBe List(-1, 0, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4)
  }

  it should "do more things" in {
    val map = Map(1 -> "one", 2 -> "two", 3 -> "three")

    1 to map.size flatMap(map.get) shouldBe Vector("one", "two", "three")
    1 to map.size map(map.get) shouldBe IndexedSeq(Some("one"), Some("two"), Some("three"))
  }


}
