
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object FeaturesOfScala extends App {
  // lazy evaluation
  lazy val alazy = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy")
    43
  }
  println(alazy)
  //println(lazyValueWithSideEffect)
  val eagerValue = lazyValueWithSideEffect + 1
  println(eagerValue)

  //Pseudo collections
  def methodCanReturnNull(): Option[String] = Option("Hello, String")
  val anOption: Option[String] = methodCanReturnNull()
  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string : $string"
    case None => "I obtained everything"
  }
  println(stringProcessing)

  def methodWhichCanThrowException(): String = throw new RuntimeException
  val aTry: Try[String] = Try(methodWhichCanThrowException())
  val anotherStringProcessing = aTry match {
    case Success(valid) => s"I have obtained a valid string : $valid"
    case Failure(ex) => s"I have obtained an exception: $ex"
  }
  println(anotherStringProcessing)

  //Evaluate something on another Thread
  //asynchronous programming
  val aFuture: Future[Int] = Future {
    println("Loading....")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }
  println(aFuture)
  Thread.sleep(2000) // Keep the main thread alive to see the Future's output

  //implicits
  def aMethodWithImplicits(implicit arg: Int) = arg + 1
  implicit val myImplicit = 46
  println(aMethodWithImplicits) //aMethodWithImplicits(myImplicit)

  //implicit conversion
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }
  println(23.isEven()) //wont work if the class is not Implicit //new MyRichInt(23).isEven()
}