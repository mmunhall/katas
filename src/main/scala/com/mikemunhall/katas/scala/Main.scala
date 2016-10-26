package com.mikemunhall.katas.scala

object Main extends App {

  override def main(str: Array[String]) = {

    // lexical closure
    def fn1(): Int => Int = {
      val y = 1
      def add(x: Int) = x + y
      add
    }

    def fn2() = {
      val y = 2
      val f = fn1()
      println(f(10))
    }

    fn2()

    // return an anonymous function
    def fn3(y: Int): Int => Int = x => x + y

    def fn4() = {
      val f = fn3(10)
      println(f(2))
    }

    fn4()
  }

}
