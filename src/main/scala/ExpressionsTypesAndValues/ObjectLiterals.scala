package ExpressionsTypesAndValues

import Helper.Example

object ObjectLiterals {

  lazy val ex1 = Example("Cat-o-matique") {

    object Oswald {
      val colour: String = "Black"
      val food: String = "Milk"
    }

    object Henderson {
      val colour: String = "Ginger"
      val food: String = "Chips"
    }

    object Quentin {
      val colour: String = "Tabby and white"
      val food: String = "Curry"
    }

  }

  type DD = Double => Double
  type II = Int => Int
  type DDTuple = Example[(DD, DD)]
  type IITuple = Example[(II, II)]

  lazy val ex2: DDTuple = Example("Square Dance") {

    object calc {
      def square(d: Double): Double = d * d
      def cube(d: Double): Double = square(d) * d
    }

    (calc.square, calc.cube)
  }



  lazy val ex3: IITuple = Example("Precise square dance") {

    object calc {
      def square(d: Double): Double = d * d
      def square(i: Int): Int = i * i
      def cube(d: Double): Double = square(d) * d
      def cube(i: Int): Int = square(i) * i
    }

    (calc.square, calc.cube)
  }

  lazy val ex4: Example[String] = Example("Greetings human") {

    object Person {
      val firstName = "Nika"
      val lastName = "Ghurtchumelia"
    }

    val p = Person

    object alien {
      def greet(p: Person.type): String = s"Hello ${p.firstName}"
    }

    alien.greet(Person)
  }




}
