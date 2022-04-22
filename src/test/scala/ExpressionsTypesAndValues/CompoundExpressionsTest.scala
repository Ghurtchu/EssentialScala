package ExpressionsTypesAndValues

import munit.FunSuite

class CompoundExpressionsTest extends FunSuite {

  import CompoundExpressions._

  test("ex1") {
    assert(ex1.get.isInstanceOf[String])
  }

  test("ex2") {
    assert(ex2.get.isInstanceOf[Any])
  }

  test("ex3") {
    assert(ex3.get.isInstanceOf[Unit])
  }
}
