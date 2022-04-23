package TypeClasses

import Helper.Exercise

object OrganisingTypeClassInstances {

  final case class Order(units: Int, unitPrice: Double) {
    val totalPrice: Double = units * unitPrice
  }

  object OrderOrderingInstances {
    implicit val totalPriceOrdering: Ordering[Order] = Ordering.fromLessThan[Order](_.totalPrice < _.totalPrice)
    implicit val unitOrdering: Ordering[Order] = Ordering.fromLessThan[Order](_.units < _.units)
    implicit val unitPriceOrdering: Ordering[Order] = Ordering.fromLessThan[Order](_.unitPrice < _.unitPrice)
  }

  lazy val ex1: Exercise[List[Order]] = Exercise("Ordering Orders") {
    List(Order(5, 2.0), Order(10, 2.0), Order(15, 1.0))
  }

}
