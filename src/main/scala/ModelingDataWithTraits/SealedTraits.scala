package ModelingDataWithTraits

import Helper.Exercise

object SealedTraits {

  sealed trait Shape {
    def sides: Int

    def perimeter: Double

    def area: Double
  }

  final case class Circle(radius: Double) extends Shape {
    private lazy val PI: Double = 3.14

    override def sides: Int = 0

    override def perimeter: Double = 2 * PI * radius

    override def area: Double = PI * radius * radius

    override def toString: String = s"Circle(radius=$radius)"
  }

  trait Rectangular extends Shape {
    override def sides: Int = 4

    def length: Double

    def width: Double

    override def perimeter: Double = 2 * length + 2 * width

    override def area: Double = width * length

    override def toString: String = s"Rectangular(length=$length, width=$width)"
  }

  final case class Rectangle(override val length: Double, override val width: Double) extends Rectangular {
    override def toString: String = s"Rectangle(length=$length, width=$width)"
  }

  final case class Square(side: Double) extends Rectangular {
    override def length: Double = side
    override def width: Double = side
    override def toString: String = s"Square(side=$side)"
  }

  object Draw {
    def apply(shape: Shape): String = shape.toString
  }

  lazy val ex1: Exercise[(Shape => String)] = Exercise("Printing shapes") {
    Draw.apply
  }

  sealed trait DivisionResult

  final case class Finite(value: Int) extends DivisionResult
  final case object Infinite extends DivisionResult

  object divide {
    def apply(a: Int, b: Int): DivisionResult =
      try Finite(a / b)
      catch {
        case _: Exception => Infinite
      }
  }

  lazy val ex2: Exercise[(Int, Int) => DivisionResult] = Exercise("A Short Division Exercise") {
    divide.apply
  }

}
