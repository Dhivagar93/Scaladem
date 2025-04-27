package check

object PatternMatching extends App{
  
  // Combined Scala file from your uploads

//Pattern Matching

//switch expression
val anInteger = 9
val order = anInteger match {
  case 1 => "one"
  case 9 => "nine"
  case _ => "Anything"
}

println(order)

//case class decomposition
case class Person(name: String, age: Int)
val bob = new Person("Diva", 10)
val personGreeting = bob match {
  case Person(n, a) => s"Hi My Name is $n and I'm $a years old"
  case _ => "Something else"
}

println(personGreeting)

//deconstructing tuples
val aTuple = ("asal", "pop")
val bandDescription = aTuple match {
  case (band, genre) => s"$band belongs to $genre"
}

println(bandDescription)

//deconstructing List
val aList = List(1, 2, 3)
val listDescription = aList match {
  case _ => "Testing if it matches anything else first"
  case List(_, 2, _) => "List containing 2 on its second position"
}

println(listDescription)

// if PM doesn't match anything, it will throw match error
// PM will try all cases in sequence


// Examples to understand 'yield'

// Without yield
val numbers = List(1, 2, 3, 4, 5)
val doubledWithoutYield = for (n <- numbers) {
  println(n * 2) // side effect
}
println(doubledWithoutYield) // Output: ()

// With yield
val doubledWithYield = for (n <- numbers) yield {
  n * 2
}
println(doubledWithYield) // Output: List(2, 4, 6, 8, 10)

}