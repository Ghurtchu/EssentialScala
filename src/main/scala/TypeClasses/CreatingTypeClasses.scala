package TypeClasses


import Helper.Exercise

object CreatingTypeClasses {

  trait Equal[T] {
    def equal(a: T, b: T): Boolean
  }

  case class Person(name: String, email: String)

  object PersonEqualInstances {
    implicit lazy val personEmailEqual: Equal[Person] = _.email == _.email
    implicit lazy val personFullEqual: Equal[Person] = (p1, p2) => personEmailEqual.equal(p1, p2) && p1.name == p2.name
  }

  lazy val ex1: Exercise[(Person, Person)] = Exercise("Equality") {
    (Person("Nikanor", "nikanor@gmail.com"), Person("Nika", "nikanor@gmail.com"))
  }

}
