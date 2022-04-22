package ModelingDataWithTraits

import Helper.Exercise

object ModelingDataWithTraits {


  sealed trait TrafficLight

  final case object Red extends TrafficLight
  final case object Green extends TrafficLight
  final case object Yellow extends TrafficLight

  sealed trait Calculation

  final case class Success(value: Int) extends Calculation
  final case class Failure(message: String) extends Calculation

  object calc {
    def apply(a: Int, b: Int)(op: (Int, Int) => Int): Calculation = {
      try Success(op(a, b))
      catch {
        case e: Exception => Failure(e.getMessage)
      }
    }
  }

  val ex1: Exercise[(Int, Int) => ((Int, Int) => Int) => Calculation] = Exercise("Stop on a Dime") {
    calc.apply
  }

  sealed trait Source

  final case object Well extends Source
  final case object Spring extends Source
  final case object Tap extends Source

  final case class Bottle(size: Int, source: Source, carbonated: Boolean)



}
