package TypeClasses

import munit.FunSuite

class ImplicitParameterAndInterfacesTest extends FunSuite {

  import ImplicitParameterAndInterfaces.{ex1, Person, Eq, Equal}

  test("ex1") {
    implicit val equalizer: Equal[Person] = ex1.get
    assert(Eq(Person("a", "b"), Person("a", "b")))
    assert(!(Eq(Person("a", "a"), Person("a", "b"))))
    assert(Equal[Person](Person("a", "b"), Person("a", "b")))
  }
}
