package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs {

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if(n <= 1) acc
    else trFact(n -1, n * acc)

  val fact10 = trFact(10)
  val fact5 = trFact(5, 2)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("Saving picture")
  //savePicture(800, 600) isn't works
  savePicture("png", 800, 600)
  savePicture(width = 800, height = 400)
  savePicture(height = 400, width = 800)

  /*
  * 1. pass in every leading argument
  * 2. name the arguments
  * */
}
