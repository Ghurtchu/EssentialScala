package SequencingComputations

import munit.FunSuite

class GenericsTest extends FunSuite {

  import Generics._

  test("ex1") {
    assertEquals(ex1.get.length, 3)
    assertEquals(Empty.length, 0)
    assertEquals(Pair(1, Empty).length, 1)
  }

  test("ex2") {
    assertEquals(ex2.get.contains(2), true)
    assertEquals(ex2.get.contains(1), true)
    assertEquals(ex2.get.contains(3), true)
    assertEquals(ex2.get.contains(5), false)
    assertEquals(Empty.contains(5), false)
  }

  test("ex3") {
    assertEquals(ex3.get(0), Success("a"))
    assertEquals(ex3.get(1), Success("b"))
    assertEquals(ex3.get(2), Success("c"))
    assertEquals(ex3.get(3), Success("d"))
    assertEquals(ex3.get(4), Success("e"))
    assertEquals(ex3.get(100), Failure("Index out of bounds exception"))
    assertEquals(ex3.get(-1), Failure("Index out of bounds exception"))
  }

  test("ex4") {

    val list = ex4.get

    assertEquals(list.fold(0)(_ + _), 15)
    assertEquals(list.fold(1)(_ * _), 120)
  }

}
