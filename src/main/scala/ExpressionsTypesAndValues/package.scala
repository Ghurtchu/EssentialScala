package object Helper {

  final class Example[A] private(val name: String, body: => A) {
    def get: A = body
  }

  object Example {
    def apply[A](name: String)(body: => A): Example[A] = new Example(name, body)
  }

}
