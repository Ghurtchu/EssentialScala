package ModelingDataWithTraits

import munit.{Fail, FunSuite}

class WorkingWithDataTest extends FunSuite {

  import WorkingWithData._
  import ModelingDataWithTraits.{TrafficLight, Red, Green, Yellow, Success, Failure}

  test("ex1") {
    val f = ex1.get

    assertEquals(f(Red), Green)
    assertEquals(f(Green), Yellow)
    assertEquals(f(Yellow), Red)
  }

  test("ex2") {
    val f = ex2.get

    val success = Success(5)
    val failure = Failure("error")

    assertEquals(f(success, 10), Success(15))
    assertEquals(f(failure, 10), Failure("error"))
  }

  test("ex3") {
    val f = ex3.get

    val success = Success(5)
    val failure = Failure("error")

    assertEquals(f(success, 10), Success(-5))
    assertEquals(f(failure, 10), Failure("error"))
  }
}
