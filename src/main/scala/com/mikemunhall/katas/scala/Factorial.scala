package com.mikemunhall.katas.scala

object Factorial {

  // Factorial e.g.: 5! == 5 * 4 * 3 * 2 * 1
  //           e.g.: 0! == 1 (a special case)
  def getResult(x: Int): Int = {
    if (x < 0) throw new IllegalArgumentException
    if (x == 0) 1 else x * getResult(x - 1)
  }

}
