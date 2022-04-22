package ObjectsAndClasses

import Helper.Exercise

import Classes.{Director, Film}

object CompanionObjects {

  class Person(val firstName: String, val lastName: String)

  object Person {
    def apply(fullName: String): Person = {
      val namePair = fullName.split(" ")
      val (fName, lName) = (namePair(0), namePair(1))
      new Person(fName, lName)
    }
  }

  lazy val ex1: Exercise[Person] = Exercise("Friendly Person Factory") {
    Person("Nika Ghurtchumelia")
  }

  object Director {
    def apply(fName: String, lName: String, yBirth: Int): Director = new Director(fName, lName, yBirth)
    def older(d1: Director, d2: Director): Director = if (d1.yearOfBirth < d2.yearOfBirth) d1 else d2
  }

  object Film {
    def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director): Film = new Film(name, yearOfRelease, imdbRating, director)
    def highestRating(f1: Film, f2: Film): Film = if (f1.imdbRating > f2.imdbRating) f1 else f2
    def oldestDirectorAtTheTime(f1: Film, f2: Film): Director = Director.older(f1.director, f2.director)
  }

  lazy val ex2: Exercise[(Director, Film)] = Exercise("Extended Body of work") {
    val director = Director("a", "b", 0)
    val film = Film("a", 0, 0, director)
    (director, film)
  }

}
