package com.mikemunhall.katas.scala

object HigherOrderFn extends App {

  def getResult(f: Int => Int, x: Int, y: Int): Int = {
    if (x == y) f(x) else
      getResult(f, x + 1, y)
  }

}