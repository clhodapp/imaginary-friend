// Copyright: 2016 Sam Halliday
// Licence: http://www.apache.org/licenses/LICENSE-2.0
package fommil

import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

import macrocompat._

/**
 * Generates dummy methods on the companion, for use in the
 * presentation compiler to spoof more complex compiler plugins, but
 * without the overhead of what they are actually doing at compile
 * time.
 */
class imaginary extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro ImaginaryFriendMacros.generate
}

@bundle
class ImaginaryFriendMacros(val c: Context) {
  import c.universe._

  def generate(annottees: c.Expr[Any]*): c.Expr[Any] = annottees.head
}
