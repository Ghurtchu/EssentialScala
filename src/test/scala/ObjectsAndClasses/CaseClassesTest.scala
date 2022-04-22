package ObjectsAndClasses

import munit.FunSuite

class CaseClassesTest extends FunSuite {

  import CaseClasses.{Counter, Cat, ex2, ex1}

  test("ex1") {
    assertEquals(ex1.get, Cat("Tommy", "Cheese"))
  }

  test("ex2") {
    assertEquals(ex2.get.inc.inc.inc.dec.value, Counter(2).value)
  }
}
