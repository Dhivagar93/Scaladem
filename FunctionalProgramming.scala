package check

object FunctionalProgramming extends App {

  // Functional Programming - Class
  class Person(name: String) {
    def apply(age: Int): Unit = println(s"I have aged $age years")
  }

  // 1. apply
  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // Same as bob.apply(43)

  
  println("---------------------------------Function x demo")
  // 2. FunctionX
  val concatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }
  println(concatenator("I like ", "someone"))

  val Incrementer = new Function1[Int, String] {
    def apply(arg1: Int): String = arg1 + " Hello"
  }
  println(Incrementer(1))

  val Praiser: Function1[Int, String] = (x: Int) => "Hello King..!!" + x
  println(Praiser(12))

  val Praiser1: String => String = (x: String) => "Hello King..!!" + x
  println(Praiser1("12"))
  
    println("---------------------------------Higher order fn demo")


  // Higher-order functions
  val aMappedList: List[Int] = List(1, 2, 3).map(x => x + 1)
  println(aMappedList)

  val aFlatMappedList = List(1, 2, 3).flatMap(x => List(x, 2 * x))
  println(aFlatMappedList)

  val aTry = List(1, 2, 3).map(_ + 1)
  println(aTry)

  val aFilter = List(1, 2, 3).filter(x => x < 3)
  println(aFilter)

  // All pairs between numbers 1,2,3 and alphabets a,b,c
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairs)

  // For comprehension for above
  val forComprehension = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  println(forComprehension)

  
    println("---------------------------------collection demo")

  // Collections
  val aList = List(1, 2, 3, 4, 5)
  println(aList.head)
  println(aList.tail)
  println("Dhiva" :: aList)
  println("Dhiva" :: aList :: "Har" :: Nil)

  // Sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3)
  val accessedElement = aSequence(0)
  println(accessedElement)

  // Vectors
  val aVector = Vector(1, 2, 3, 4, 5)

  // Sets
  val aSet = Set(1, 2, 3, 4, 5, 1, 2, 3)
  val aSetHas = aSet.contains(1)
  println(aSetHas)
  val aSetAdd = aSet + 1
  println(aSetAdd)

  // Ranges
  val aRange = 1 to 1000
  println(aRange)
  val twoByTwo = aRange.map(x => 2 * x).toList
  println(twoByTwo.take(10)) // printing only first 10 elements for brevity

  // Tuples
  val aTuple = ("John", 9)
  println(aTuple)

  // Map
  val aPhonebook: Map[String, Int] = Map(
    "Dhiva" -> 2930,
    "Har" -> 5346
  )
  println(aPhonebook)
}
