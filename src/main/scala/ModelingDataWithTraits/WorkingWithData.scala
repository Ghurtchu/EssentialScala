package ModelingDataWithTraits

import scala.language.postfixOps
import Helper.Exercise
import ModelingDataWithTraits.{TrafficLight, Red, Green, Yellow, Calculation, Success, Failure, calc}


object WorkingWithData {

  object TrafficLight {
    def next(t: TrafficLight): TrafficLight = t match {
      case Red => Green
      case Green => Yellow
      case Yellow => Red
    }
  }

  lazy val ex1: Exercise[TrafficLight => TrafficLight] = Exercise("Traffic Lights") {
    TrafficLight.next
  }

  object Calculation {
    def +(c: Calculation, n: Int): Calculation = c match {
      case Success(v) => Success(v + n)
      case Failure(m) => Failure(m)
    }
    def -(c: Calculation, n: Int): Calculation = c match {
      case Success(v) => Success(v - n)
      case Failure(m) => Failure(m)
    }
  }


  lazy val ex2: Exercise[(Calculation, Int) => Calculation] = Exercise("Calculation") {
    Calculation +
  }

  lazy val ex3: Exercise[(Calculation, Int) => Calculation] = Exercise("Calculation") {
    Calculation -
  }

}
