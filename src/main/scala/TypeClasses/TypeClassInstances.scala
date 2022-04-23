package TypeClasses

import Helper.Exercise

object TypeClassInstances {

  implicit val absOrdering: Ordering[Int] = Ordering.fromLessThan[Int]((a, b) => Math.abs(a) < Math.abs(b))

  lazy val ex1: Exercise[Ordering[Int]] = Exercise("Absolute") {
    absOrdering
  }

  final case class Rational(n: Int, d: Int) {
    def result: Double = n.toDouble / d.toDouble
  }

  implicit val rationalOrdering: Ordering[Rational] = Ordering.fromLessThan[Rational](_.result < _.result)

}
