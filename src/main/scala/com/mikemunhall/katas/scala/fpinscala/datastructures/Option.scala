package com.mikemunhall.katas.scala.fpinscala.datastructures

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(a) => Some(f(a))
  }

  def flatMapMatcher[B](f: A => Option[B]): Option[B] = this match {
    case None => None
    case Some(v) => f(v)
  }

  def flatMap[B](f: A => Option[B]): Option[B] = map(f) getOrElse None

  def getOrElse[B >: A](default: => B): B = this match {
    case None => default
    case Some(v) => v
  }

  def orElseMatcher[B >: A](ob: => Option[B]): Option[B] = this match {
    case None => ob
    case Some(v) => Some(v)
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = this map (Some(_)) getOrElse ob

  def filterMatcher(f: A => Boolean): Option[A] = this match {
    case Some(v) if f(v) => this
    case _ => None
  }

  def filter(f: A => Boolean): Option[A] = flatMap(a => if (f(a)) Some(a) else None)

  def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f

  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    a flatMap (aa => b map (bb => f(aa, bb)))
  }

  def map3[A, B, C, D](a: Option[A], b: Option[B], c: Option[C])(f: (A, B, C) => D): Option[D] = {
    a flatMap (aa => b flatMap (bb => c map (cc => f(aa, bb, cc))))
  }

  def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
    case Nil => Some(Nil)
    case Cons(h, t) => h flatMap (hh => sequence(t) map (Cons(hh, _)))
  }

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
    case Nil => Some(Nil)
    case Cons(h, t) => map2(f(h), traverse(t)(f))(Cons(_, _))
  }

  val absO: Option[Double] => Option[Double] = lift(math.abs)
}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]
