package ObjectsAndClasses

import Helper.Exercise

object Classes extends App {

  class Cat(val name: String, val colour: String, val food: String) {
    def stringify: String = name concat colour concat food
  }

  lazy val ex1: Exercise[(Cat, Cat, Cat)] = Exercise("Cats, Again") {
    val oswald = new Cat("Oswald", "Black", "Milk")
    val henderson = new Cat("Henderson", "Ginger", "Chips")
    val quentin = new Cat("Quentin", "Tabby and white", "Curry")

    (oswald, henderson, quentin)
  }

  lazy val ex2: Exercise[Cat => Boolean] = Exercise("Cats on the Prowl") {
    object ChipShop {
      def willServe(c: Cat): Boolean = c.food == "Chips"
    }

    ChipShop.willServe
  }

  class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
    def name: String = firstName concat " " concat lastName

    override def equals(obj: Any): Boolean = {
      if (!obj.isInstanceOf[Director]) return false
      val other: Director = obj.asInstanceOf[Director]

      this.firstName == other.firstName && this.lastName == other.lastName && this.yearOfBirth == other.yearOfBirth
    }
  }

  class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
    def directorsAge: Int = yearOfRelease - director.yearOfBirth

    def isDirectedBy(d: Director): Boolean = d.firstName == director.firstName && d.lastName == director.lastName

    def copy(newName: String, newYearOfRelease: Int, newImdbRating: Double, newDirector: Director): Film = new Film(newName, newYearOfRelease, newImdbRating, newDirector)

    override def equals(obj: Any): Boolean = {
      if (!obj.isInstanceOf[Film]) return false
      val other: Film = obj.asInstanceOf[Film]
      name == other.name && yearOfRelease == other.yearOfRelease && imdbRating == other.imdbRating
    }
  }

  lazy val ex3: Exercise[(Director, Film)] = Exercise("Directional Debut") {

    val director = new Director("Random", "Dude", 1950)
    val film = new Film("Pursue of happiness", 2017, 8.5, director)

    (director, film)
  }

  class Counter(private val value: Int) {
    def inc: Counter = new Counter(value + 1)
    def dec: Counter = new Counter(value - 1)
    def count: Int = value
  }

  lazy val ex4: Exercise[Counter] = Exercise("A Simple counter") {
    new Counter(0)
  }

  class EnhancedCounter(private val value: Int) {

    def inc: EnhancedCounter = new EnhancedCounter(value + 1)

    def inc(n: Int): EnhancedCounter = {
      if (n == 0 ) this
      else if (n > 0) inc.inc(n - 1)
      else new EnhancedCounter(value)
    }

    def dec: EnhancedCounter = new EnhancedCounter(value - 1)

    def dec(n: Int): EnhancedCounter = {
      if (n == 0) this
      else if (n > 0) dec.dec(n - 1)
      else new EnhancedCounter(value)
    }

    def count: Int = value
  }

  lazy val ex5: Exercise[EnhancedCounter] = Exercise("Counting Faster") {
    new EnhancedCounter(0)
  }

  class Adder(amount: Int) {
    def add(in: Int): Int = amount + in
  }

  class CounterWithAdder(value: Int) extends Counter(value) {
    def adjust(adder: Adder): CounterWithAdder = new CounterWithAdder(adder.add(value))
  }

  lazy val ex6: Exercise[(Adder, CounterWithAdder)] = Exercise("Counter with Adder") {
    (new Adder(5), new CounterWithAdder(5))
  }

}
