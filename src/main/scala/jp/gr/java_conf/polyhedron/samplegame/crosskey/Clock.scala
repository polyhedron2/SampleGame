package jp.gr.java_conf.polyhedron.samplegame.crosskey

import jp.gr.java_conf.polyhedron.splittersprite3.agent
import jp.gr.java_conf.polyhedron.splittersprite3.common
import jp.gr.java_conf.polyhedron.splittersprite3.spirit.{Spirit}
import jp.gr.java_conf.polyhedron.splittersprite3.vanilla


object ReturnEnum extends Enumeration {
  val base = Value
}

class ModeSpawner(spirit: Spirit) extends vanilla.ModeSpawner(spirit) {
  lazy val returnEnum = ReturnEnum
  lazy val clock = new Clock()
}

class Clock() extends vanilla.Clock {
  val returnEnum = ReturnEnum

  def command(windowName: String, command: common.Command) {
    command match {
      case common.KeyPress("Up") => Status.direction = Direction.Up
      case common.KeyPress("Down") => Status.direction = Direction.Down
      case common.KeyPress("Left") => Status.direction = Direction.Left
      case common.KeyPress("Right") => Status.direction = Direction.Right
      case _ =>
    }
  }

  def forward() = ReturnEnum.base
}
