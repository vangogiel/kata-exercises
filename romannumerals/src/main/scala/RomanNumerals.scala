object RomanNumerals {
  val romanMap = Map(
    "I" -> 1,
    "V" -> 5,
    "X" -> 10,
    "L" -> 50 ,
    "C" -> 100,
    "M" -> 1000,
    "D" -> 500
  )

  def convert(str: String): Int = {
    var result = 0
    val elements = str.split("")
    var counter = 0
    do {
      val currentElement = elements(counter)
      if (elements.length - 1 > counter && romanMap(currentElement) < romanMap(elements(counter + 1))) {
        result += romanMap(elements(counter + 1)) - romanMap(currentElement)
        counter += 1
      } else {
        result += romanMap(elements(counter))
      }
      counter += 1
    } while(counter < elements.length)
    result
  }
}
