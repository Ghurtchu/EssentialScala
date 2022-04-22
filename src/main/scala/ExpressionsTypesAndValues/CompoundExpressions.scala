package ExpressionsTypesAndValues

import Helper.Example

object CompoundExpressions {

  lazy val ex1 = Example("A Classic Rivalry") {
    if (1 > 2) "alien" else "predator"
  }

  lazy val ex2 = Example("A less well known rivalry") {
    if (1 > 2) "alien" else 2001
  }

  lazy val ex3 = Example("An if without an else") {
    if (false) "hello"
  }
}
