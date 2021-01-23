package lectures.part3fp

import scala.util.{Failure, Success}

object Handlingfailure extends App {

  //create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)
}
