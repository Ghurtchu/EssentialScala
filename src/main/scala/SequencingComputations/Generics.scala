package SequencingComputations

import Helper.Exercise

import scala.collection.immutable.ArraySeq

object Generics {


  trait Result[+A]

  final case class Success[A](value: A) extends Result[A]

  final case class Failure[A](reason: String) extends Result[A]

  sealed trait LinkedList[+A] {
    def head: A

    def tail: LinkedList[A]

    def length: Int

    def contains[B >: A](b: B): Boolean

    def apply(n: Int): Result[A]

    def fold[B >: A](base: B)(f: (B, B) => B): B
  }

  object LinkedList {
    def apply[A](elems: A*): LinkedList[A] = if (elems.isEmpty) Empty else Pair(elems.head, apply(elems.tail: _*))
  }


  final case object Empty extends LinkedList[Nothing] {
    override def head: Nothing = throw new NoSuchElementException

    override def tail: LinkedList[Nothing] = this

    override def length: Int = 0

    override def contains[B >: Nothing](b: B): Boolean = false

    override def apply(n: Int): Result[Nothing] = Failure("No such element exception")

    override def fold[B >: Nothing](base: B)(f: (B, B) => B): B = base
  }

  final case class Pair[+A](override val head: A, override val tail: LinkedList[A]) extends LinkedList[A] {
    override def length: Int = this match {
      case Pair(head, Empty) => 1
      case Pair(head, tail) => 1 + tail.length
    }

    override def contains[B >: A](b: B): Boolean = this match {
      case Pair(head, Empty) => head == b
      case Pair(head, t) => if (head == b) true else t contains b
    }

    override def apply(n: Int): Result[A] = if (n < 0 || n > length) Failure("Index out of bounds exception") else if (n == 0) Success(head) else tail.apply(n - 1)

    override def fold[B >: A](base: B)(f: (B, B) => B): B = this match {
      case Pair(h, Empty) => f(base, h)
      case Pair(h, t) => f(h, t.fold(base)(f))
    }
  }

  lazy val ex1: Exercise[LinkedList[_]] = Exercise("Working with generic types") {
    LinkedList[Int](1, 2, 3)
  }

  lazy val ex2: Exercise[LinkedList[_]] = Exercise("Contains") {
    LinkedList[Int](1, 2, 3)
  }

  lazy val ex3: Exercise[LinkedList[String]] = Exercise("Apply") {
    LinkedList[String]("a", "b", "c", "d", "e")
  }

  lazy val ex4: Exercise[LinkedList[Int]] = Exercise("Fold") {
    LinkedList[Int](1, 2, 3, 4, 5)
  }

}
