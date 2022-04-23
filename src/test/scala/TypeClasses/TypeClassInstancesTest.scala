package TypeClasses

import munit.FunSuite

class TypeClassInstancesTest extends FunSuite {

  import TypeClassInstances._

  test("ex1") {
    assertEquals(List(1, -2, -4, 3).sorted, List(1, -2, 3, -4))
  }

  test("ex2") {
    assertEquals(List(
      Rational(2, 3), // 0.6
      Rational(1, 2), // 0.5
      Rational(3, 4), // 0.75
      Rational(1, 3) // 0.3
    ).sorted, List(
      Rational(1, 3),
      Rational(1, 2),
      Rational(2, 3),
      Rational(3, 4)
    ))
  }

}
