package TypeClasses

import Helper.Exercise

object EnrichedInterfaces {

  implicit class IntTimesSyntax(n: Int) {
    def times(f: Int => Unit): Unit = if (n == 1) f(n) else if (n > 1) { f(n); (n-1).times(f)} else {}
  }

  trait Equal[A] {
    def equals(a: A, b: A): Boolean
  }

  implicit object StringEquals extends Equal[String] {
    override def equals(a: String, b: String): Boolean = a == b
  }

  implicit class StringEqualSyntax(a: String) {
    def ===(b: String)(implicit equal: Equal[String]): Boolean = equal.equals(a, b)
  }

  lazy val ex: Exercise[List[Boolean]] = Exercise("String equals syntax") {
    List(
      "str" === "str",
      "other" === "other",
      "not eq" === "bla bla"
    )
  }
}
