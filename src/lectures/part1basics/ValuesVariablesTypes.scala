package lectures.part1basics

object ValuesVariablesTypes extends App {

  //Values(immutable - can't be reassigned)
  val a = 42 //inferred type
  println(a)
  val b: Int = 65
  println(b)
  val c: String = "Hello"
  println(c)
  val d: Boolean = true
  println(d)
  val e: Char = 'M'
  println(e)
  val f: Short = 2323
  println(f)
  val g: Long = 434343434343l
  println(g)
  val h:Float = 12.4f
  println(h)
  val i: Double = 3.14d
  println(i)

  //Variables (mutable - can be reassigned)
  var aa: Int = 4
  println(aa)

  var bb = 10
  println(bb)
  bb = 13
  println(bb)
  bb += 2
  println(bb)
}
