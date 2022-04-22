package ExpressionsTypesAndValues

import munit.FunSuite

class ObjectLiteralsTest extends FunSuite {

  import ObjectLiterals._

  test("ex2") {
    val square = ex2.get._1
    val cube = ex2.get._2

    assertEquals(square(2.0), 4.0)
    assertEquals(cube(2.0), 8.0)
  }

  test("ex3") {
    val squareInt = ex3.get._1
    val cubeInt = ex3.get._2

    assertEquals(squareInt(2), 4)
    assertEquals(cubeInt(2), 8)
  }

  test("ex4") {
    assertEquals(ex4.get, "Hello Nika")
  }

}
