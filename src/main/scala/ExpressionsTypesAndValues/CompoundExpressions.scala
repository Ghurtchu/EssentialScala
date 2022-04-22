package ExpressionsTypesAndValues

import Helper.Exercise

object CompoundExpressions {

  lazy val ex1 = Exercise("A Classic Rivalry") {
    if (1 > 2) "alien" else "predator"
  }

  lazy val ex2 = Exercise("A less well known rivalry") {
    if (1 > 2) "alien" else 2001
  }

  lazy val ex3 = Exercise("An if without an else") {
    if (false) "hello"
  }
}
