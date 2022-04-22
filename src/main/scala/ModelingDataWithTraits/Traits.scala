package ModelingDataWithTraits

import Helper.Exercise

import ObjectsAndClasses.CaseClasses.Cat

object Traits {

  trait Feline {
    def color: String

    def sound: String
  }

  case class Cat(name: String, override val color: String, favFood: String) extends Feline {
    override def sound: String = "meow"
  }

  case class Tiger(name: String, override val color: String) extends Feline {
    override def sound: String = "roar"
  }

  case class Lion(name: String, override val color: String, maneSize: Int) extends Feline {
    override def sound: String = "roar"
  }

  trait Shape {
    def sides: Int
    def perimeter: Double
    def area: Double
  }

  case class Circle(radius: Double) extends Shape {
    private lazy val PI: Double = 3.14
    override def sides: Int = 0
    override def perimeter: Double = 2 * PI * radius
    override def area: Double = PI * radius * radius
  }

  trait Rectangular extends Shape {
    def length: Double
    def width: Double
    override def sides: Int = 4
    override def perimeter: Double = 2 * length + 2 * width
    override def area: Double = width * length
  }

  case class Rectangle(override val length: Double, override val width: Double) extends Rectangular

  case class Square(side: Double) extends Rectangular {
    override def width: Double = side
    override def length: Double = side
  }

}
