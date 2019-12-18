package uselists

object UseAList {
  def lookAt(l: Any): Unit = l match {
//    case List() => println("That's an empty list")
    case Nil => println("That's an empty list")
    case List(x, y, z) => println(s"Three element list ${x}, ${y}, and ${z}")
    case _ => println("I don't know what that is")
  }

  def lookCloser(l: Any): Unit = l match {
    case Nil => println("Empty")
    case h :: t => println(s"Head is ${h}, tail is ${t}")
    case _ => println("Doesn't look like a list")
  }

  def main(args: Array[String]): Unit = {
    val l = List("Fred", "Jim", "Sheila")
    println(s"List is ${l}")
    lookAt(l)
    lookAt(List("X", "Y"))
    lookAt(List())

    // :: pronounced "cons"
    println(s"longer list is ${"Albert" :: l}")

    val l3 = "A" :: "B" :: "C" :: Nil
    println(l3)
    lookCloser(l3)
  }
}
