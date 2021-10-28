import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.wordspec.AnyWordSpecLike

class RomanNumeralsSpec extends AnyWordSpecLike {

  "RomanNumerals" should {
    "convert IV into 4" in {
      RomanNumerals.convert("IV") mustBe 4
    }

    "convert IX into 9" in {
      RomanNumerals.convert("IX") mustBe 9
    }

    "convert XXIX into 29" in {
      RomanNumerals.convert("XXIX") mustBe 29
    }

    "convert LXXX into 80" in {
      RomanNumerals.convert("LXXX") mustBe 80
    }

    "convert CCXCIV into 294" in {
      RomanNumerals.convert("CCXCIV") mustBe 294
    }

    "convert MMXIX into 2019" in {
      RomanNumerals.convert("MMXIX") mustBe 2019
    }

    "convert CMXCIX into 999" in {
      RomanNumerals.convert("CMXCIX") mustBe 999
    }

    "convert CDXCIX into 499" in {
      RomanNumerals.convert("CDXCIX") mustBe 499
    }

    "convert MMMCDLXV into 3465" in {
      RomanNumerals.convert("MMMCDLXV") mustBe 3465
    }
  }
}
