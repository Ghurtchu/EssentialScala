package ExpressionsTypesAndValues

import Helper.Exercise

object ObjectLiterals {

  lazy val ex1 = Exercise("Cat-o-matique") {

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
  type DDTuple = Exercise[(DD, DD)]
  type IITuple = Exercise[(II, II)]

  lazy val ex2: DDTuple = Exercise("Square Dance") {

    object calc {
      def square(d: Double): Double = d * d
      def cube(d: Double): Double = square(d) * d
    }

    (calc.square, calc.cube)
  }

  lazy val ex3: IITuple = Exercise("Precise square dance") {

    object calc {
      def square(d: Double): Double = d * d
      def square(i: Int): Int = i * i
      def cube(d: Double): Double = square(d) * d
      def cube(i: Int): Int = square(i) * i
    }

    (calc.square, calc.cube)
  }

  lazy val ex4: Exercise[String] = Exercise("Greetings human") {

    object Person {
      val firstName = "Nika"
      val lastName = "Ghurtchumelia"
    }

    object alien {
      def greet(p: Person.type): String = s"Hello ${p.firstName}"
    }

    alien.greet(Person)
  }




}
