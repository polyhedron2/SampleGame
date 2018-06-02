package jp.gr.java_conf.polyhedron.samplegame.crosskey

import javafx.geometry.{Pos}
import javafx.scene.image.{ImageView}
import javafx.scene.image.{Image}
import javafx.scene.layout.{StackPane}
import javafx.scene.{Scene}

import jp.gr.java_conf.polyhedron.splittersprite3.{Atmosphere}
import jp.gr.java_conf.polyhedron.splittersprite3.spirit.{Spirit}
import jp.gr.java_conf.polyhedron.splittersprite3.spawner.{OutermostSpawner}
import jp.gr.java_conf.polyhedron.splittersprite3.vanilla

class ViewSpawner(val spirit: Spirit) extends OutermostSpawner[View] {
  lazy val upImage = spirit.image("上")
  lazy val downImage = spirit.image("下")
  lazy val leftImage = spirit.image("左")
  lazy val rightImage = spirit.image("右")

  def createInstance(env: Environment) = new View(
    upImage, downImage, leftImage, rightImage, env)

  type SpawnArgs = Environment
  val fakeArgs = new Environment()
}

class View(
    upImage: => Image, downImage: => Image,
    leftImage: => Image, rightImage: => Image,
    env: Environment) extends vanilla.View() {
  def render() {
    val directionImage = env.direction match {
      case Direction.Up => upImage
      case Direction.Down => downImage
      case Direction.Left => leftImage
      case Direction.Right => rightImage
    }

    Atmosphere.javaFXTaskQueue.enqueue { case primaryStage =>
      val pane = new StackPane()
      pane.setAlignment(Pos.CENTER)

      val scene = new Scene(
        pane, directionImage.getWidth(), directionImage.getHeight())
      primaryStage.setScene(scene)

      val directionImageView = new ImageView(directionImage)
      pane.getChildren().add(directionImageView)
    }
  }
}
