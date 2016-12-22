package com.mikemunhall.katas.scala.fpinscala.datastructures

import org.scalatest.{FlatSpec, Matchers}

class TreeSpec extends FlatSpec with Matchers {

  "Tree" should "do all the things!" in {

    /*
               B
             /   \
            B     B
           / \   / \
          1   B 8   4
             / \
            2   3
     */
    val tree = Branch(Branch(Leaf(1), Branch(Leaf(2), Leaf(3))), Branch(Leaf(8), Leaf(4)))

    Tree.size(tree) shouldBe 9
    Tree.sizeViaFold(tree) shouldBe 9
    Tree.maximum(tree) shouldBe 8
    Tree.maximumViaFold(tree) shouldBe 8
    Tree.depth(tree) shouldBe 4
    Tree.depthViaFold(tree) shouldBe 4
    Tree.map(tree)(_.toString) shouldBe Branch(Branch(Leaf("1"), Branch(Leaf("2"), Leaf("3"))), Branch(Leaf("8"), Leaf("4")))
    Tree.mapViaFold(tree)(_.toString) shouldBe Branch(Branch(Leaf("1"), Branch(Leaf("2"), Leaf("3"))), Branch(Leaf("8"), Leaf("4")))
  }
}