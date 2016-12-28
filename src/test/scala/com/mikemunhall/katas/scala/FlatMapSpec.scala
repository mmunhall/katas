package com.mikemunhall.katas.scala

import java.net.InetSocketAddress

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

  "flatMap" should "remove None form Option" in {
    def toInt(s: String): Option[Int] = {
      try {
        Some(Integer.parseInt(s.trim))
      } catch {
        // catch Exception to catch null 's'
        case e: Exception => None
      }
    }

    val strings = Seq("1", "2", "foo", "3", "bar")

    strings.map(toInt) shouldBe Seq(Some(1), Some(2), None, Some(3), None)
    strings.flatMap(toInt) shouldBe Seq(1, 2, 3)
  }

  it should "flatten this, too" in {
    val list = List(1, 2, 3, 4)
    def g(v: Int) = List(v - 1, v, v + 1)

    list.map(g) shouldBe List(List(0, 1, 2), List(1, 2, 3), List(2, 3, 4), List(3, 4, 5))
    list.flatMap(g) shouldBe List(0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4, 5)
  }

  it /*can*/ should "be used to produce permutations of two items" in {
    val chars = 'a' to 'z'
    val perms = chars flatMap { a =>
      chars flatMap { b =>
        if (a != b) Seq("%c%c".format(a, b))
        else Seq()
      }
    }
    perms.size shouldBe 650
    perms.head shouldBe "ab"
    perms.last shouldBe "zy"
  }

  it /*can*/ should "be used to produce permutations of three items" in {
    val chars = 'a' to 'z'
    val perms = chars flatMap { a =>
      chars flatMap { b =>
        chars flatMap { c =>
          Seq("%c%c%c".format(a, b, c))
        }
      }
    }
    println(perms)
    perms.size shouldBe 17576
    perms.head shouldBe "aaa"
    perms.last shouldBe "zzz"
  }

  it /*can*/ should "be used to construct objects this way" in {
    def addr(host: Option[String], port: Option[Int]): Option[InetSocketAddress] =
      host flatMap { h =>
        port map { p =>
          new InetSocketAddress(h, p)
        }
      }

    val addr1 = addr(Some("mikemunhall.com"), Some(80))
    val addr2 = addr(Some("mikemunhall.com"), None)
    val addr3 = addr(None, Some(80))

    addr1 shouldBe a [Some[_]]
    addr2 shouldBe None
    addr3 shouldBe None

  }


}
