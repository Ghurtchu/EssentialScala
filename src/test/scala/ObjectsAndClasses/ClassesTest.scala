package ObjectsAndClasses

import munit.FunSuite

class ClassesTest extends FunSuite {

  import Classes._

  test("ex1") {
    val oswald = ex1.get._1
    val henderson = ex1.get._2
    val quentin = ex1.get._3

    assertEquals("OswaldBlackMilk", oswald.stringify)
    assertEquals("HendersonGingerChips", henderson.stringify)
    assertEquals("QuentinTabby and whiteCurry", quentin.stringify)
  }

  test("ex2") {
    val willServe = ex2.get

    val tommy = new Cat("Tommy", "Blue", "Chips")
    val martin = new Cat("Martin", "Red", "Milk")

    assertEquals(willServe(tommy), true)
    assertEquals(willServe(martin), false)
  }

  test("ex3") {
    val director = ex3.get._1
    val film = ex3.get._2

    assertEquals(director.name, "Random Dude")
    assertEquals(film.isDirectedBy(director), true)
    assertEquals(film.isDirectedBy(new Director("Bla", "Bla", 0)), false)
    assertEquals(film.directorsAge, film.yearOfRelease - director.yearOfBirth)
  }

  test("ex4") {
    val counter = ex4.get

    assertEquals(counter.inc.inc.inc.count, 3)
    assertEquals(counter.inc.dec.count, 0)
    assertEquals(counter.dec.dec.count, -2)
  }

  test("ex5") {
    val enhancedCounter = ex5.get

    assertEquals(enhancedCounter.inc(5).count, 5)
    assertEquals(enhancedCounter.dec(10).inc(5).count, -5)
  }

  test("ex6") {
    val adder = ex6.get._1
    val counterWithAdder = ex6.get._2

    assertEquals(counterWithAdder.adjust(adder).count, 10)
    assertEquals(counterWithAdder.adjust(new Adder(10)).count, 15)
    assertEquals(counterWithAdder.adjust(new Adder(-10)).count, -5)
  }

}
