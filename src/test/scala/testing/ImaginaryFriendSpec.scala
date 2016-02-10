// Copyright: 2016 Sam Halliday
// Licence: http://www.apache.org/licenses/LICENSE-2.0

// intentionally not in fommil for testing
package testing

import fommil.imaginary

import org.scalatest._

@imaginary
class Me

@imaginary
class Myself(val foo: String, val bar: Long)

@imaginary
class Mine(val foo: String = "foo", val bar: Long = 13)

class ImaginaryFriendSpec extends FlatSpec with Matchers {
  "@imaginary" should "generate companion's apply with no parameters" in {
    Me() shouldBe be a classOf[Me]
  }

  it should "generate companion apply with parameters" in {
    Myself("foo") should be a classOf[Myself]
  }

  it should "generate companion apply with named / default parameters" in {
    Myself("foo") shouldBe be a classOf[Myself]
    Myself(foo = "foo") shouldBe be a classOf[Myself]
    Myself(bar = 10) shouldBe be a classOf[Myself]
  }

}
