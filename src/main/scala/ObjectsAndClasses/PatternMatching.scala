package ObjectsAndClasses

import Helper.Exercise
import CaseClasses.{Film, Director, Cat}

object PatternMatching {

  val ex1: Exercise[Cat => Boolean] = Exercise("Feed the cats") {

    object ChipShop {
      def willServe(c: Cat): Boolean = c.food match {
        case "Chips" => true
        case _ => false
      }
    }

    ChipShop.willServe
  }

  val ex2: Exercise[Film => Double] = Exercise("Get off my lawn") {

    object Dad {
      def rate(f: Film): Double = f.director.name match {
        case "Clint Eastwood" => 10.0
        case "John McTiernan" => 7.0
        case _ => 3.0
      }
    }

    Dad.rate
  }

}
