package utils

import java.text.Normalizer

/**
  * Created by PixelMan on 21/12/2016.
  */
object StringUtils {

  def standardToHyphenCase(str: String) = {
    Normalizer.normalize(str, Normalizer.Form.NFD)
        .replaceAll("\\p{M}", "")
        .toLowerCase
        .replaceAll("\\s", "-")
  }

  def standardToSnakeCase(str: String) = {
    Normalizer.normalize(str, Normalizer.Form.NFD)
      .replaceAll("\\p{M}", "")
      .toLowerCase
      .replaceAll("\\s", "_")
  }
}
