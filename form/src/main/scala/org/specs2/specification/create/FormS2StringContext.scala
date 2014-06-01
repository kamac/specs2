package org.specs2
package specification
package create

import core._
import form._
/**
 * Allow to use forms inside interpolated strings starting with s2 in order to build the specification content
 */
trait FormS2StringContext extends S2StringContext { this: FormFragmentsFactory =>
  private val factory = fragmentFactory
  import factory._

  private val formFactory = formFragmentFactory
  import formFactory._

  implicit def formIsInterpolatedPart(f: =>Form): InterpolatedPart = new InterpolatedPart {
    override def append(parts: Vector[Fragment], text: String, expression: String): Vector[Fragment] =
      parts :+ Text(text) :+ FormFragment(f.executeForm)
  }

  implicit def toFormIsInterpolatedPart(f: { def form: Form}): InterpolatedPart = formIsInterpolatedPart(f.form)

}

