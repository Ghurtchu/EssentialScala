package TypeClasses

import Helper.Exercise

object ImplicitParameterAndInterfaces {

  trait Equal[T] {
    def equal(a: T, b: T): Boolean
  }

  object Equal {
    def apply[T](a: T, b: T)(implicit equal: Equal[T]): Boolean = equal.equal(a, b)
  }

  case class Person(name: String, email: String)

  implicit object PersonEmailEqual extends Equal[Person] {
    override def equal(a: Person, b: Person): Boolean = a.email == b.email
  }

  implicit object  PersonFullEqual extends Equal[Person] {
    override def equal(a: Person, b: Person): Boolean = PersonEmailEqual.equal(a, b) && a.name == b.name
  }

  object Eq {
    def apply[T](a: T, b: T)(implicit equal: Equal[T]): Boolean = equal.equal(a, b)
  }

  lazy val ex1: Exercise[Equal[Person]] = Exercise("Equality Again") {
    PersonFullEqual
  }

}
