package utils

import org.scalatest._

class StringUtilsSpec extends FlatSpec with Matchers {

  "StandardToHyphenCase" should "return 'psy-fee' with entry 'Psy Fée'" in {
    (StringUtils standardToHyphenCase "Psy Fée") shouldBe "psy-fee"
  }


  "StandardToSnakeCase" should "return 'psy_fee' with entry 'Psy Fée'" in {
    (StringUtils standardToSnakeCase "Psy Fée") shouldBe "psy_fee"
  }

  it should "return 'maelys_sena' with entry 'Maelys Sena'" in {
    (StringUtils standardToSnakeCase "Maelys Sena") shouldBe "maelys_sena"
  }
}
