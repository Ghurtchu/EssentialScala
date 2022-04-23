package TypeClasses

import munit.FunSuite

class OrganisingTypeClassInstancesTest extends FunSuite {

  import OrganisingTypeClassInstances._

  test("ex1") {
    {
      import OrderOrderingInstances.totalPriceOrdering
      assertEquals(ex1.get.sorted, List(Order(5, 2.0), Order(15, 1.0), Order(10, 2.0)))
    }
    {
      import OrderOrderingInstances.unitOrdering
      assertEquals(ex1.get.sorted, List(Order(5, 2.0), Order(10, 2.0), Order(15, 1.0)))
    }
    {
      import OrderOrderingInstances.unitPriceOrdering
      assertEquals(ex1.get.sorted, List(Order(15, 1.0), Order(5, 2.0), Order(10, 2.0)))
    }
  }


}
