package ObjectsAndClasses

import munit.FunSuite

class PatternMatchingTest extends FunSuite {

  import PatternMatching._
  import CaseClasses.{Film, Cat, Director}

  test("ex1") {
    val c1 = Cat("black", "Chips")
    val c2 = Cat("white", "Milk")

    val f: Cat => Boolean = ex1.get

    assertEquals(f(c1), true)
    assertEquals(f(c2), false)
  }

  test("ex2") {
    val f1 = Film("", 0, 0, Director("Clint", "Eastwood", 0))
    val f2 = Film("", 0, 0, Director("John", "McTiernan", 0))
    val f3 = Film("", 0, 0, Director("John", "De Goes", 0))

    val f = ex2.get

    assertEquals(f(f1), 10.0)
    assertEquals(f(f2), 7.0)
    assertEquals(f(f3), 3.0)
  }





}
