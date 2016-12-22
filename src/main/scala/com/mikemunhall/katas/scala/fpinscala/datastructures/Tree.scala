package com.mikemunhall.katas.scala.fpinscala.datastructures

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def size[A](as: Tree[A]): Int = as match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + size(l) + size(r)
  }

  def maximum(as: Tree[Int]): Int = as match {
    case Leaf(v) => v
    case Branch(l, r) => maximum(l) max maximum(r)
  }

  def depth[A](as: Tree[A]): Int = as match {
    case Leaf(v) => 1
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }

  def map[A, B](as: Tree[A])(f: A => B): Tree[B] = as match {
    case Leaf(v) => Leaf(f(v))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }

  def mapViaFold[A, B](as: Tree[A])(f: A => B): Tree[B] = fold(as)(a => Leaf(f(a)): Tree[B])(Branch(_, _))
  def depthViaFold[A](as: Tree[A]): Int = fold(as)(_ => 1)((d1, d2) => 1 + (d1 max d2))
  def sizeViaFold[A](as: Tree[A]): Int = fold(as)(_ => 1)(1 + _ + _)
  def maximumViaFold(as: Tree[Int]): Int = fold(as)(a => a)(_ max _)

  def fold[A, B](t: Tree[A])(f: A => B)(g: (B, B) => B): B = t match {
    case Leaf(v) => f(v)
    case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
  }

}