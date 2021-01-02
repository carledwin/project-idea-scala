package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I'm learning Scala"
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')

  println(str.reverse)
  println(str.take(2))

  //Scala-specific: String interpolators

  //S-interpolators
  val name = "Carl"
  val age = 37
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"

  println(greeting)
  println(anotherGreeting)

  //F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  val anotherMyth = f"$name%s can eat $speed%2.2f burgers per minute"
  val minute = 1
  val ananotherMyth = f"$name%s can eat $speed%2.2f burgers in [$minute%3d]"
  println(myth)
  println(anotherMyth)
  println(ananotherMyth)

  //raw-interpolator
  println(raw"This is a \n newline")

  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
