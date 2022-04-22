package ModelingDataWithTraits

import munit.FunSuite

class SealedTraitsTest extends FunSuite {

  import SealedTraits._

  test("ex1") {
    val f = ex1.get

    val square = Square(5.0)

    assertEquals(f(square), "Square(side=5.0)")
  }

  test("ex2") {
    val f = ex2.get

    val success = f(5, 1)
    val failure = f(5, 0)

    assertEquals(success, Finite(5))
    assertEquals(failure, Infinite)
  }
}
