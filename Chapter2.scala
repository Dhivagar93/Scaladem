package check

object Chapter2 extends App{
  

// String interpolation on case class
case class Radio(Song: String, genre: String){}

val favSong = Radio("Muruga", "Devotional")

println(s"My fav song is ${favSong.Song} and genre is ${favSong.genre}")

println(s"Does the song belong to Devotional: ${favSong.genre == "Devotional"}")

// Escape characters
val multijson =
  """
    |{
    |  "School": {
    |    "attendance": "2025-04-01 09:59:02.179",
    |    "Amount": "3XXX",
    |    "Fees": "30742187",
    |    "Pass": "Yes",
    |    "TimestampIn": "2025-04-01 09:19:21.000",
    |    "Id": "30742187"
    |  }
    |}
  """.stripMargin

println(multijson)

// For loop with yield
val songs = List("Muruga", "Siva", "Ganesha")

val yeilddemo = for {
  song <- songs if (song == "Ganesha" || song == "Muruga")
} yield song

println(yeilddemo.mkString("_"))

// While and do-while
val sing = "Om namashivaya"
var count = 108

while (count > 0) {
  println(s"$count time $sing")
  count -= 1
}

// Match with if and type check
val godName1 = "Om nama Shivaya, Om muruga"

val nameCheck = godName1 match {
  case name if (name.contains("Shivaya") || name.contains("Muruga")) => "Shiva family"
  case "Bhairva" => "rest of god"
  case _ => "other Gods"
}

println(nameCheck)

val godName: Any = "Om nama Shivaya, Om muruga"

val typeCheck = godName match {
  case _: Int => "name is Int"
  case _: String => "name is String"
}

println(typeCheck)

// Tuple
val TupleSample = Tuple3("God", "name", "count")

println(s"${TupleSample._1} name is Shiva")

val TupleList = List(TupleSample)

val TupleMatch: Unit = TupleList.foreach { tuple =>
  tuple match {
    case ("God", "name", "Log") => println("match found")
    case d if d._1 == "God" => println("omg")
    case _ =>
  }
}

println(TupleMatch)

// Option Some and None
val Optionalaction: Option[String] = Some("Roll around the temple")
val Noaction: Option[String] = None

println(s"Calling optional Action ${Optionalaction.get}")
println(s"Calling no Action ${Noaction.getOrElse("No action required")}")

val OptionMatch = Optionalaction match {
  case Some(name) => "some value"
  case None => "No value"
}

println(OptionMatch)

// Function with no parentheses
def noParanthesis = {
  println("no parentheses")
  godName1.concat(" ohm")
}

println(noParanthesis)

// Default values to function parameters
def Defaultparameters(Godname: String, chant: String, flower: String = "JASMINE"): String = {
  Godname.concat(s" $chant honored with ") + flower
}

println(Defaultparameters(godName1, "Om", "ROSE"))

// Option demo function
def optionDemo(): Option[String] = {
  val flowers = "JASMINE"
  Option(flowers)
}

println(s"Option is ${optionDemo()}")
  
}