package com.mikemunhall.katas.scala

object Factorial {

  // Factorial e.g.: 5! == 5 * 4 * 3 * 2 * 1
  //           e.g.: 0! == 1 (a special case)
  def getResult(x: Int): Int = {
    x match {
      case x if x < 0 => throw new IllegalArgumentException
      case x if x == 0 => 1
      case x => getResult(x - 1) * x
    }
  }

}
