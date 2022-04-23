package SequencingComputations

import munit.FunSuite

class ModelingDataWithGenericTypesTest extends FunSuite {

  import ModelingDataWithGenericTypes._

  test("ex1") {
    assertEquals(ex1.get, Full(5))
  }

}
