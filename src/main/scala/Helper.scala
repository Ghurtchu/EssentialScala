package object Helper {

  final class Exercise[A] private(val name: String, body: => A) {
    def get: A = body
  }

  object Exercise {
    def apply[A](name: String)(body: => A): Exercise[A] = new Exercise(name, body)
  }

}
