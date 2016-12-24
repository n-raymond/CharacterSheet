package utils

import org.specs2.mutable._

class StringUtilsSpec extends Specification{

  "StandardToHyphenCase" should {

    "return 'psy-fee' with entry 'Psy Fée'" in {
      (StringUtils standardToHyphenCase "Psy Fée") must_=== "psy-fee"
    }

  }

  "StandardToSnakeCase" should {

    "return 'psy_fee' with entry 'Psy Fée'" in {
      (StringUtils standardToSnakeCase "Psy Fée") must_=== "psy_fee"
    }

    "return 'maelys_sena' with entry 'Maelys Sena'" in {
      (StringUtils standardToSnakeCase "Maelys Sena") must_=== "maelys_sena"
    }
  }
}
