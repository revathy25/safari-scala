package mydates

//import java.util._

object Date {
  def dayOfWeek(day: Int, month: Int, year: Int = 2019): Int = {
    //    val m = if (month < 3) month + 12 else month // ? :
    //    val y = if (month < 3) year - 1 else year
    val (m, y) = if (month < 3) (month + 12, year - 1) else (month, year)
    (day + (13 *(m + 1) / 5) + y + y / 4 - y / 100 + y / 400) % 7
  }

  def dayName(d: Int): String = d match {
    case 0 => "Saturday"
    case 1 => "Sunday"
    case 2 => "Monday"
    case 3 => "Tuesday"
    case 4 => "Wednesday"
    case 5 => "Thursday"
    case 6 => "Friday"
    case _    => "Not sure about that"
  }
//  def dayName(d: Int): String =
//    if (d == 0) /*return*/ "Saturday"
//    else if (d == 1) "Sunday"
//    else {
//      val toreturn = "Unk" + "nown"
//      println("Oops, I don't think you meant that!")
//      toreturn
//    }

  def main(args: Array[String]): Unit = {
    println(s"Day 0 is ${dayName(0)}")
    println(s"Day 1 is ${dayName(1)}")
    println(s"Day 9 is ${dayName(9)}")

//    println(s"Day of week today is ${dayName(dayOfWeek(month=12, day=18, year=2019))}")
    println(s"Day of week today is ${dayName(dayOfWeek(month=12, day=18))}")
  }
}
