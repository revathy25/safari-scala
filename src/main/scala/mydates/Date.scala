package mydates

import java.sql.SQLException

import mydates.Date.{dayName, dayOfWeek}

//import java.util._

//class Date(d: Int, m: Int, y: Int) {
////  var day:Int = _ // default initialization (only for var, not val)
//  var day:Int = d
//  var month:Int = m
//  var year:Int = y
//class Date(val day: Int, val month: Int, val year: Int) {
class Date protected (private/*[this]*/ var day: Int, private var month: Int, private var year: Int) {
  if (day < 1 || day > /*daysInMonth(month, year)*/ 31)
    throw new IllegalArgumentException
//    throw new SQLException // Scala does not do "checked exceptions"

  // "Auxilary constructor"
  /*protected*/ def this(d: Int, m: Int) = {
    this(d, m, 2019)
    println("In auxiliary constructor")
  }

  println(s"Creating a Date, day ${day}, month ${month}, year ${year}")

  override def toString:String =
    s"Date: day=${day}, month=${this.month}, year = ${year}"
}

object Date {
  def apply(d: Int, m: Int, y: Int): Date =
    new Holiday(d, m, y, "Every day is a holiday at Disneyland")

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
}

class Holiday(d: Int, m: Int, y: Int, val name: String)
  extends Date(d, m, y) {
  override def toString: String = s"Holiday on ${super.toString} named ${name}"
}

object UseDates {
  def main(args: Array[String]): Unit = {
    println(s"Day 0 is ${dayName(0)}")
    println(s"Day 1 is ${dayName(1)}")
    println(s"Day 9 is ${dayName(9)}")

    //    println(s"Day of week today is ${dayName(dayOfWeek(month=12, day=18, year=2019))}")
    println(s"Day of week today is ${dayName(dayOfWeek(month=12, day=18))}")

    val d = /*new */Date(18, 12, 2019) // uses factory, is "Date.apply..."
//    d.day = 99 // immutable if it's a val, inaccessible as a private
    println(s"The date is ${d}")

    val d2 = new Date(31, 12)
    println(s"End of year is ${d2}")

    val h1 = new Holiday(1, 1, 2020, "New Year")
    println(s"New year is: ${h1}")
  }
}