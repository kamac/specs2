package org.specs2
package specification
package process

import specification.core._
import scalaz.stream.{Process, process1}
import Process.Process1
import scalaz.syntax.monoid._

trait Statistics {

  def statsProcess: Process1[Fragment, Stats] =
    process1.reduceMap { fragment =>
      fragment.execution.executedResult.map(Stats.apply).getOrElse(Stats())
    }

  def fold = (fragment: Fragment, stats: Stats) =>
    stats |+| fragment.execution.executedResult.map(Stats.apply).getOrElse(defaultStats(fragment))

  def defaultStats(fragment: Fragment) =
    if (Fragment.isExample(fragment)) Stats(examples = 1)
    else                              Stats()
}

object Statistics extends Statistics
