package Collections

import munit.FunSuite

class SequencesTest extends FunSuite {

  import Sequences._

  test("ex1") {
    assertEquals(ex1.get, Seq("mouse","cat", "dog", "penguin", "tyrannosaurus"))
  }

  test("ex2") {
    assertEquals(
      ex2.get(2).length, 3)
  }

  test("ex3") {
    assertEquals(ex3.get(1980).length, 3)
  }

}
