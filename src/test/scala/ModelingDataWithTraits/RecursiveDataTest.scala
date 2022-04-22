package ModelingDataWithTraits

import munit.FunSuite

class RecursiveDataTest extends FunSuite {

  import RecursiveData._

  test("ex1") {
    assertEquals(ex1.get, 3)
    assertEquals(Pair(1, End).length, 1)
    assertEquals(End.length, 0)
  }

  test("ex2") {
    assertEquals(ex2.get, 6)
    assertEquals(End.product, 0)
    assertEquals(Pair(1, End).product, 1)
  }

  test("ex3") {
    assertEquals(ex3.get, Pair(2, Pair(4, Pair(6, End))))
    assertEquals(End.double, End)
    assertEquals(Pair(10, End).double, Pair(20, End))
  }

  test("ex4") {
    assertEquals(ex4.get.sum, 3)
    assertEquals(ex4.get.double, Node(Leaf(2), Leaf(4)))
  }

  test("ex5") {
    val tree = ex5.get
    assertEquals(IntTree.sum(tree), 15)
    assertEquals(IntTree.double(tree), Node(Leaf(10), Leaf(20)))
  }

  test("ex6") {
    val res = ex6.get
    assertEquals(res, Success(10.0))
    assertEquals(Expression.eval(Addition(Number(5.0), Addition(Number(5.0), Number(10.0)))), Success(20.0))
    assertEquals(Expression.eval(Subtraction(Addition(Number(10.0), Number(10.0)), Number(5.0))), Success(15.0))
  }

  test("ex7") {
    val jsonString = ex7.get
    assertEquals(jsonString, "{\n  \"patientWeights\": [\"99 lbs\",\"120 lbs\"],\n  \"recordName\": \"medicalRecord\",\n  \"patientAges\": [10,20],\n  \"isMigrated\": true,\n  \"score\": 10,\n}")
  }


}
