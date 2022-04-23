package TypeClasses

import munit.FunSuite

class CreatingTypeClassesTest extends FunSuite {

  import CreatingTypeClasses._

  test("ex1") {
    val (p1, p2) = ex1.get

    {
      import PersonEqualInstances.personEmailEqual
      assert(personEmailEqual.equal(p1, p2))
    }

    {
      import PersonEqualInstances.personFullEqual
      assert(!personFullEqual.equal(p1, p2))
    }

  }

}
