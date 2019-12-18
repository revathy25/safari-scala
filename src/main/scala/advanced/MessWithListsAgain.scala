package advanced

object MessWithListsAgain {
  def doToList[T](l:List[T])(implicit op: (T) => Unit):Unit = l match {
    case Nil =>
    case h :: t => op(h); doToList(t)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Fred", "Jim", "Sheila")
    doToList(names)(x => println(s"Dear ${x}, nice to meet you"))

    implicit val showNum: Int => Unit = x => println(s"The number is ${x}")
    doToList(List(1, 2, 3))
  }
}
