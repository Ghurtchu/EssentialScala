package TypeClasses

object JsonSerialisation {

  sealed trait JsValue {
    def stringify: String
  }

  final case class JsObject(values: Map[String, JsValue]) extends
    JsValue {
    def stringify: String = values
      .map { case (name, value) => "\"" + name + "\":" + value.stringify
      }
      .mkString("{", ",", "}")
  }

  final case class JsString(value: String) extends JsValue {
    def stringify: String = "\"" + value.replaceAll("\\|\"", "\\\\$1") + "\""
  }

  trait JsWriter[A] {
    def write(a: A): JsValue
  }

  object JsUtil {
    def toJson[A](a: A)(implicit jsWriter: JsWriter[A]): JsValue = jsWriter write a
  }

  import java.util.Date

  sealed trait Visitor {
    def id: String

    def createdAt: Date

    def age: Long = new Date().getTime - createdAt.getTime
  }

  final case class Anonymous(
                              id: String,
                              createdAt: Date = new Date()
                            ) extends Visitor

  final case class User(
                         id: String,
                         email: String,
                         createdAt: Date = new Date()
                       ) extends Visitor

  implicit class VisitorJsonSyntax(v: Visitor) {
    def jsonify(implicit jsWriter: JsWriter[Visitor]): JsValue = VisitorJsonWriter write v
  }

  object UserJsonWriterInstances {
    implicit val userJsonWriter: JsWriter[User] = user => JsObject(Map("id" -> JsString(user.id), "email" -> JsString(user.email), "createdAt" -> JsString(user.createdAt.toString)))
  }

  object AnonymousJsonWriterInstances {
    implicit val anonymousJsonWriter: JsWriter[Anonymous] = anon => JsObject(Map("id" -> JsString(anon.id), "createdAt" -> JsString(anon.createdAt.toString)))
  }

  import UserJsonWriterInstances._
  import AnonymousJsonWriterInstances._

  implicit object VisitorJsonWriter extends JsWriter[Visitor] {
    override def write(a: Visitor): JsValue = a match {
      case anon: Anonymous => JsUtil toJson anon
      case user: User => JsUtil toJson user
    }
  }

  import Helper.Exercise

  val ex: Exercise[Seq[Visitor]] = Exercise("Json Serialisation") {
    val visitors: Seq[Visitor] = Seq(Anonymous("001", new Date), User("003", "dave@xample.com", new Date))
    visitors
  }
}
