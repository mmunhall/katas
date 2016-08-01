package scala.com.mikemunhall.scalakatas.scala

import org.scalatest._

class FizzBuzzSpec extends FlatSpec with Matchers {

  val fn35 = FizzBuzz.getResult(3, 5) _
  val fn69 = FizzBuzz.getResult(6, 9) _

  "FizzBuzz with 3 and 5 divisors" should "return fizz if the number is dividable by 3" in {
    fn35(3) should be ("fizz")
    fn35(6) should be ("fizz")
  }

  it should "return buzz if the number is dividable by 5" in {
    fn35(5) should be ("buzz")
    fn35(10) should be ("buzz")
  }

  it should "return fizzbuzz if the number is dividable by 3 and 5" in {
    fn35(15) should be ("fizzbuzz")
    fn35(30) should be ("fizzbuzz")
  }

  it should "return the same number if no other requirement is fulfilled" in {
    fn35(1) should be ("1")
    fn35(2) should be ("2")
    fn35(4) should be ("4")
  }

  "FizzBuzz with 6 and 9 divisors" should "return fizz if the number is dividable by 6" in {
    fn69(6) should be ("fizz")
    fn69(24) should be ("fizz")
  }

  it should "return buzz if the number is dividable by 9" in {
    fn69(9) should be ("buzz")
    fn69(81) should be ("buzz")
  }

  it should "return fizzbuzz if the number is dividable by 6 and 9" in {
    fn69(54) should be ("fizzbuzz")
    fn69(108) should be ("fizzbuzz")
  }

  it should "return the same number if no other requirement is fulfilled" in {
    fn69(1) should be ("1")
    fn69(2) should be ("2")
    fn69(13) should be ("13")
  }

}