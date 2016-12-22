package com.mikemunhall.katas.scala.fpinscala.datastructures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def tail[A](as: List[A]): List[A] = as match {
    case Nil => sys.error("tail of empty list")
    case Cons(_, t) => t
  }

  def setHead[A](as: List[A], a: A): List[A] = as match {
    case Nil => sys.error("tail of empty list")
    case Cons(_, t) => Cons(a, t)
  }

  def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
    case (Nil, _) => Nil
    case (_, n) if n == 0 => l
    case (Cons(_, t), n) => drop(t, n - 1)
  }

  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(h, t) if f(h) => dropWhile(t)(f)
    case l => l
  }

  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h,t) => Cons(h, append(t, a2))
  }

  def init[A](l: List[A]): List[A] = l match {
    case Nil => sys.error("It's a Nil thing.")
    case Cons(_, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))
  }

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(h, t) => h + sum(t)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(h, t) => h * product(t)
  }

  def foldRight[A, B](ds: List[A], z: B)(f: (A, B) => B): B = ds match {
    case Nil => z
    case Cons(h, t) => f(h, foldRight(t, z)(f))
  }

  @annotation.tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

  def concat[A](l: List[List[A]]): List[A] = foldRight(l, Nil:List[A])(append)
  def sum2(ds: List[Int]): Int = foldRight(ds, 0)(_ + _)
  def sum3(ds: List[Int]): Int = foldLeft(ds, 0)(_ + _)
  def product2(ds: List[Double]): Double = foldRight(ds, 1.0)(_ * _)
  def product3(ds: List[Double]): Double = foldLeft(ds, 1.0)(_ * _)
  def length[A](as: List[A]): Int = foldRight(as, 0)((_, acc) => acc + 1)
  def length2[A](as: List[A]): Int = foldLeft(as, 0)((acc, _) => acc + 1)
  def reverse[A](as: List[A]): List[A] = foldLeft(as, List[A]())((b, a) => Cons(a, b))
  def append2[A](l: List[A], r: List[A]): List[A] = foldRight(l, r)(Cons(_, _))
  def intAddOne(l: List[Int]): List[Int] = foldRight(l, List[Int]())((h, t) => Cons(h + 1, t))
  def doubleToString(l: List[Double]): List[String] = foldRight(l, Nil:List[String])((h, t) => Cons(h.toString, t))
  def map[A, B](l: List[A])(f: A => B): List[B] = foldRight(l, Nil:List[B])((h, t) => Cons(f(h), t))
  def filter[A](as: List[A])(f: A => Boolean): List[A] = foldRight(as, Nil:List[A])((h, t) => if (f(h)) Cons(h, t) else t)
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = foldLeft(as, List[B]())((b, a) => concat(map(as)(f)))
  def filter2[A](as: List[A])(f: A => Boolean): List[A] = flatMap(as)(a => if (f(a)) List(a) else Nil)
  def addPairwise(a: List[Int], b: List[Int]): List[Int] = (a, b) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(h1 + h2, addPairwise(t1, t2))
  }
  def zipWith[A, B, C](a: List[A], b: List[B])(f: (A, B) => C): List[C] = (a, b) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(f(h1, h2), zipWith(t1, t2)(f))
  }
  @annotation.tailrec
  def startsWith[A](l: List[A], prefix: List[A]): Boolean = (l,prefix) match {
    case (_,Nil) => true
    case (Cons(h,t),Cons(h2,t2)) if h == h2 => startsWith(t, t2)
    case _ => false
  }
  @annotation.tailrec
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = sup match {
    case Nil => sub == Nil
    //case _ => startsWith(sup, sub)
    case Cons(h,t) => hasSubsequence(t, sub)
    case _ => startsWith(sup, sub)
  }











  /*/*def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(h, t) => h + sum(t)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }*/

  @annotation.tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case Cons(h, t) => foldLeft(t, f(z, h))(f)
    }
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case Cons(h, t) => f(h, foldRight(t, z)(f))
    }
  }

  def append[A](as: List[A], z: List[A]): List[A] = foldRight(as, z)(Cons(_, _))

  def sum(ints: List[Int]): Int = {
    //foldRight(ints, 0)(_ + _)
    foldLeft(ints, 0)(_ + _)
  }

  def product(ds: List[Double]): Double = {
    //foldRight(ds, 0.0)(_ * _)
    foldLeft(ds, 1.0)(_ * _)
  }



  def tail[A](xs: List[A]): List[A] = xs match {
    case Nil => Nil // should throw an exception rather than pass silently
    case Cons(_, t) => t
  }

  def setHead[A](xs: List[A], x: A): List[A] = xs match {
    case Nil => Nil // should throw an exception rather than pass silently
    case Cons(_, t) => Cons(x, t)
  }

  def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
    case (Nil, _) => Nil // should throw an exception rather than pass silently
    case (l, 0) => l
    case (Cons(_, t), n) => drop(t, n - 1)
  }

  /*def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h, t) if f(h) => dropWhile(t, f)
    case _ => l
  }*/

  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Cons(h, t) if f(h) => dropWhile(t)(f)
    case _ => l
  }

  // cannot use tail recursion here.
  // could rewrite using a buffer to take advantage of tail calls
  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(h, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))
  }

  /*def length[A](as: List[A]): Int = as match {
    case Nil => 0
    case Cons(h, t) => 1 + length(t)
  }*/

  def length[A](as: List[A]): Int = {
    //foldRight(as, 0)((_, acc) => acc + 1)
    foldLeft(as, 0)((acc, _) => acc + 1)
  }

  // List(1, 2, 3) becomes List(3, 2, 1)
  def reverse[A](as: List[A]): List[A] = foldLeft(as, List[A]())((acc, h) => Cons(h, acc))*/
}
