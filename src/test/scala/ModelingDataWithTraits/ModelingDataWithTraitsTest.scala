package ModelingDataWithTraits

import munit.FunSuite

class ModelingDataWithTraitsTest extends FunSuite {

  import ModelingDataWithTraits._

  test("ex1") {
    val f = ex1.get

    val expectedSum: Calculation = f(10, 20)(_ + _)
    val expectedProduct: Calculation = f(1, 2)(_ * _)
    val expectedFailure: Calculation = f(1, 0)(_ / _)

    assertEquals(expectedSum, Success(30))
    assertEquals(expectedProduct, Success(2))
    assert(expectedFailure.isInstanceOf[Failure])
  }
}
