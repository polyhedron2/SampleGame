package jp.gr.java_conf.polyhedron.samplegame.crosskey

import jp.gr.java_conf.polyhedron.splittersprite3.{Atmosphere}
import jp.gr.java_conf.polyhedron.splittersprite3.common
import jp.gr.java_conf.polyhedron.splittersprite3.spirit.{Spirit}
import jp.gr.java_conf.polyhedron.splittersprite3.spawner.{OutermostSpawner}
import jp.gr.java_conf.polyhedron.splittersprite3.vanilla

class ControllerSpawner(spirit: Spirit)
    extends vanilla.ControllerSpawner(spirit) {
  lazy val viewSpawner = spirit.outermostSpawner[ViewSpawner]("view")
  val env = new Environment()

  def createInstance(x: Unit) = new Controller(viewSpawner.spawn(env), env)
}

class Controller(view: View, env: Environment) extends vanilla.Controller() {
  lazy val initialState = OnlyOneState

  object OnlyOneState extends State {
    type ModelState = Unit
    def modelState2operation(modelState: ModelState) = Stay
    val model = new Model(env)
    val viewSeq = Seq[vanilla.View](view)
  }
}
