package ModelingDataWithTraits

import Helper.Exercise

object RecursiveData {


  sealed trait IntList {
    def length: Int

    def product: Int

    def double: IntList
  }

  case object End extends IntList {
    override def length: Int = 0

    override def product: Int = 0

    override def double: IntList = this
  }

  final case class Pair(head: Int, tail: IntList) extends IntList {
    override def length: Int = 1 + tail.length

    override def product: Int = this match {
      case Pair(h, End) => h
      case Pair(h, t) => h * t.product
    }

    override def double: IntList = this match {
      case Pair(h, End) => Pair(2 * h, End)
      case Pair(h, t) => Pair(2 * h, t.double)
    }
  }

  lazy val ex1: Exercise[Int] = Exercise("A List of Methods") {
    Pair(1, Pair(2, Pair(3, End))).length
  }

  lazy val ex2: Exercise[Int] = Exercise("Product") {
    Pair(1, Pair(2, Pair(3, End))).product
  }

  lazy val ex3: Exercise[IntList] = Exercise("Double") {
    Pair(1, Pair(2, Pair(3, End))).double
  }


  sealed trait IntTree {
    def sum: Int

    def double: IntTree
  }

  final case class Leaf(value: Int) extends IntTree {
    override def sum: Int = value

    override def double: IntTree = Leaf(2 * value)
  }

  final case class Node(left: IntTree, right: IntTree) extends IntTree {
    override def sum: Int = left.sum + right.sum

    override def double: IntTree = Node(left.double, right.double)
  }

  object IntTree {

    def sum(intTree: IntTree): Int = intTree match {
      case Leaf(v) => v
      case Node(l, r) => sum(l) + sum(r)
    }

    def double(intTree: IntTree): IntTree = intTree match {
      case Leaf(v) => Leaf(2 * v)
      case Node(l, r) => Node(double(l), double(r))
    }

  }

  lazy val ex4: Exercise[IntTree] = Exercise("IntTree Pattern matching") {
    Node(Leaf(1), Leaf(2))
  }

  lazy val ex5: Exercise[IntTree] = Exercise("IntTree Polymorphism") {
    Node(Leaf(5), Leaf(10))
  }

  sealed trait Expression

  final case class Addition(left: Expression, right: Expression) extends Expression
  final case class Subtraction(left: Expression, right: Expression) extends Expression
  final case class Division(left: Expression, right: Expression) extends Expression
  final case class SquareRoot(expr: Expression) extends Expression
  final case class Number(value: Double) extends Expression

  sealed trait Result

  final case class Success(value: Double) extends Result
  final case class Failure(message: String) extends Result

  object Expression {
    def eval(expr: Expression): Result = expr match {

      case Number(v) => Success(v)

      case Addition(l, r) => eval(l) match {
        case Failure(reason) => Failure(reason)
        case Success(v1) => eval(r) match {
          case Failure(reason) => Failure(reason)
          case Success(v2) => Success(v1 + v2)
        }
      }

      case Subtraction(l, r) => eval(l) match {
        case Failure(reason) => Failure(reason)
        case Success(v1) => eval(r) match {
          case Failure(reason) => Failure(reason)
          case Success(v2) => Success(v1 - v2)
        }
      }

      case Division(l, r) => eval(l) match {
        case Failure(reason) => Failure(reason)
        case Success(v1) => eval(r) match {
          case Failure(message) => Failure(message)
          case Success(v2) => {
            if (v2 != 0) Success(v1 / v2)
            else Failure("Division by zero")
          }
        }
      }


      case SquareRoot(v) =>
        eval(v) match {
          case Success(r) =>
            if(r < 0)
              Failure("Square root of negative number")
            else
              Success(Math.sqrt(r))
          case Failure(reason) => Failure(reason)
        }

     }
  }

  lazy val ex6: Exercise[Result] = Exercise("A Calculator") {
    Expression.eval(Addition(Number(5.0), Number(5.0)))
  }


  sealed trait Json

  final case class JsonArray(get: Array[Json]) extends Json {
    override def toString: String = get.map(_.toString).mkString("[",",","]")
  }

  final case class JsonNumber(get: Int) extends Json {
    override def toString: String = get.toString
  }

  final case class JsonString(get: String) extends Json {
    override def toString: String = s"\"${get}\""
  }

  final case class JsonBoolean(get: Boolean) extends Json {
    override def toString: String = get.toString
  }

  final case class JsonObject(get: Map[String, Json]) extends Json {
    override def toString: String = get.map {
      case (k, v) => s"  \"$k\": ${v.toString},\n"
    }.mkString("{\n","","}")
  }

  object Json {
    def toString(json: Json): String = json match {
      case JsonArray(arr) => arr.map(_.toString).mkString("[",",","]")
      case JsonString(str) => s"\"${str}\""
      case JsonBoolean(bool) => bool.toString
      case JsonObject(map) => map.map {
        case (k, v) => s"  \"$k\": ${v.toString},\n"
      }.mkString("{\n","","}")
      case JsonNumber(num) => num.toString
    }
  }

  lazy val ex7: Exercise[String] = Exercise("JSON") {
    JsonObject(Map(
      "patientAges" -> JsonArray(Array(JsonNumber(10), JsonNumber(20))),
      "recordName" -> JsonString("medicalRecord"),
      "isMigrated" -> JsonBoolean(true),
      "patientWeights" -> JsonArray(Array(JsonString("99 lbs"), JsonString("120 lbs"))),
      "score" -> JsonNumber(10)
    )).toString
  }

}
