package useimplicit

object UseImplicits {
  // very bad form to use implicits of "common" types
  def show(implicit x: Int): Unit = println(s"> ${x}" )

  def main(args: Array[String]): Unit = {
    val value: Int = 99
    show(value)

    {
      // Libraries OFTEN have a package or an object
      // called implicits or something like it
      // providing useful but changable
      // defaults for both values and behaviors

      import Implicits._
      show
//    }
//
//    {
      implicit val otherNumber = -5
      show(otherNumber)
    }

  }
}
