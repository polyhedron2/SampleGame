package jp.gr.java_conf.polyhedron.samplegame.crosskey

import jp.gr.java_conf.polyhedron.splittersprite3.agent
import jp.gr.java_conf.polyhedron.splittersprite3.common
import jp.gr.java_conf.polyhedron.splittersprite3.vanilla

class Model(env: Environment) extends vanilla.Model[Unit] {
  def command(windowName: String, command: common.Command) {
    command match {
      case common.KeyPress("Up") => env.direction = Direction.Up
      case common.KeyPress("Down") => env.direction = Direction.Down
      case common.KeyPress("Left") => env.direction = Direction.Left
      case common.KeyPress("Right") => env.direction = Direction.Right
      case _ =>
    }
  }

  def update() {
  }
}
