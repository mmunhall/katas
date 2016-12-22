package com.mikemunhall.katas.scala.fpinscala.datastructures

import org.scalatest.{FlatSpec, Matchers}

class ListSpec extends FlatSpec with Matchers {

  "List" should "do all the things!" in {
    val List0123 = List(0, 1, 2, 3)
    val List123 = List(1, 2, 3)
    val ListNil = Nil
    val List0123d = List(0.0, 1.0, 2.0, 3.0)
    val List123d = List(1.0, 2.0, 3.0)

    List.tail(List123) shouldBe Cons(2, Cons(3, Nil))
    List.setHead(List123, 0) shouldBe Cons(0, Cons(2, Cons(3, Nil)))
    List.drop(List123, 1) shouldBe Cons(2, Cons(3, Nil))
    List.drop(List123, 2) shouldBe Cons(3, Nil)
    List.drop(ListNil, 2) shouldBe Nil
    //    List.dropWhile(List123, (a: Int) => a >= 1) shouldBe Nil
    //    List.dropWhile(List123, (a: Int) => a >= 2) shouldBe Cons(1, Cons(2, Cons(3, Nil)))
    //    List.dropWhile(List123, (a: Int) => a <= 2) shouldBe Cons(3, Nil)
    List.dropWhile(List123)((a: Int) => a >= 1) shouldBe Nil
    List.dropWhile(List123)(a => a >= 2) shouldBe Cons(1, Cons(2, Cons(3, Nil)))
    List.dropWhile(List123)(_ <= 2) shouldBe Cons(3, Nil)
    List.append(List123, List(4)) shouldBe Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
    List.init(List123) shouldBe Cons(1, Cons(2, Nil))
    List.sum(List123) shouldBe 6
    List.sum2(List123) shouldBe 6
    List.sum3(List123) shouldBe 6
    List.product(List123d) shouldBe 6.0
    List.product2(List123d) shouldBe 6.0
    List.product3(List123d) shouldBe 6.0
    List.length(List123) shouldBe 3
    List.length2(List123) shouldBe 3
    List.reverse(List123) shouldBe Cons(3, Cons(2, Cons(1, Nil)))
    List.append2(List123, List(4)) shouldBe Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
    List.intAddOne(List123) shouldBe List(2, 3, 4)
    List.doubleToString(List123d) shouldBe List("1.0", "2.0", "3.0")
    List[String]() shouldBe Nil
    List[String]() should be(Nil: List[String])
    List.map(List123)((a: Int) => (a + 1).toString) shouldBe List("2", "3", "4")
    List.filter(List123)(_ % 2 == 0) shouldBe List(2)
    List.flatMap(List123)(i => List(i, i)) shouldBe List(1, 1, 2, 2, 3, 3)
    List.filter2(List(1, 2, 2, 3))(_ % 2 == 0) shouldBe List(2, 2)
    List.addPairwise(List123, List(3, 4, 5)) shouldBe List(4, 6, 8)
    List.zipWith(List123, List(3, 4, 5))(_ + _) shouldBe List(4, 6, 8)
  }
}