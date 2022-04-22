package ObjectsAndClasses

import Helper.Exercise

object CaseClasses {

  case class Cat(color: String, food: String)

  val ex1: Exercise[Cat] = Exercise("Case Cats") {
    Cat("Tommy", "Cheese")
  }

  case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
    def name: String = firstName concat " " concat lastName
  }

  case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {
    def directorsAge: Int = yearOfRelease - director.yearOfBirth

    def isDirectedBy(d: Director): Boolean = d.firstName == director.firstName && d.lastName == director.lastName
  }

  case class Counter(value: Int = 0) {
    def inc: Counter = copy(value + 1)
    def dec: Counter = copy(value - 1)
  }

  val ex2: Exercise[Counter] = Exercise("Case class counter") {
    Counter()
  }
}
