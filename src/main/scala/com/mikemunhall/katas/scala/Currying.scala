package com.mikemunhall.katas.scala

object Currying {

  def getResult2(x: Int): Int => Int = y => y + x
  def getResult3(x: Int): Int => (Int => Int) = y => (z => x + y + z)

}
