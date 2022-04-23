package TypeClasses

import Helper.Exercise
import munit.FunSuite

class EnrichedInterfacesTest extends FunSuite {

  import EnrichedInterfaces._

  test("ex1") {
    5.times(n => println(n))
  }

  test("ex") {
    val booleanList = ex.get
    assert(booleanList.head)
    assert(booleanList.tail.head)
    assert(!booleanList.last)
  }
}
