package ObjectsAndClasses

import munit.FunSuite

class CompanionObjectsTest extends FunSuite {

  import CompanionObjects._

  test("ex1") {
    val p = ex1.get
    assertEquals("Nika", p.firstName)
    assertEquals("Ghurtchumelia", p.lastName)
  }

  test("ex2") {
    val tup = ex2.get
    val director = tup._1
    val film = tup._2

    val actualDirector = Director("a", "b", 0)
    val actualFilm = Film("a", 0, 0, Director("a", "b", 0))

    assertEquals(film, actualFilm)
    assertEquals(director, actualDirector)
  }

  

}
