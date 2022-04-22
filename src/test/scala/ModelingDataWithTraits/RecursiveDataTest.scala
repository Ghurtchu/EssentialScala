package ModelingDataWithTraits

import munit.FunSuite

import scala.collection.immutable.ListMap

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

    val exampleJson = ex7.get
    println(exampleJson)
    assertEquals(exampleJson, "{\n  \"patientAges\": [10,20],\n  \"recordName\": \"medicalRecord\",\n  \"isMigrated\": true,\n  \"patientWeights\": [\"99 lbs\",\"120 lbs\"],\n  \"score\": 10,\n}")

    val emptyJson = Json(JsonObject(Map()))
    println(emptyJson)
    assertEquals(emptyJson, "{}")

    val signleKeyJson = Json(JsonObject(Map("scala" -> JsonString("cool"))))

    println(signleKeyJson)
    assertEquals(signleKeyJson, "{\n  \"scala\": \"cool\" \n}")

    val complexJson = Json(JsonObject(
      ListMap(
        "odersky" -> JsonString("great"),
        "scalaCommunityIsGreat" -> JsonBoolean(true),
        "javaBeatsScala" -> JsonBoolean(false),
        "mySalaryInFuture" -> JsonNumber(100000000),
        "myFriendList" -> JsonArray(Array()))))

    println(complexJson)

    assertEquals(complexJson, "{\n  \"odersky\": \"great\", \n  \"scalaCommunityIsGreat\": true, \n  \"javaBeatsScala\": false, \n  \"mySalaryInFuture\": 100000000, \n  \"myFriendList\": [] \n}")
  }


}
