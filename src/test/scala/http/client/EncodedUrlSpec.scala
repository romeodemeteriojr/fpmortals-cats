// Copyright: 2017 - 2018 https://gitlab.com/fommil/drone-dynamic-agents/graphs/master
// License: http://www.gnu.org/licenses/gpl-3.0.en.html

package http.client

import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class EncodedUrlSpec extends FlatSpec {
  "EncodedUrl" should "require ascii encoding" in {
    // from https://en.wikipedia.org/wiki/URL
    assert(EncodedUrl("http://example.com/引き割り.html").isLeft)

    EncodedUrl
      .encode("http://example.com/引き割り.html")
      .shouldBe(
        EncodedUrl(
          "http://example.com/%E5%BC%95%E3%81%8D%E5%89%B2%E3%82%8A.html"
        )
      )

    // seems the JDK doesn't work correctly with
    // "http://例子.卷筒纸" shouldBe "http://xn--fsqu00a.xn--3lr804guic/"
  }

}
