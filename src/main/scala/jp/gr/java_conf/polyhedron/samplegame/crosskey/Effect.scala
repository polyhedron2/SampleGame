package jp.gr.java_conf.polyhedron.samplegame.crosskey

import javafx.geometry.{Pos}
import javafx.scene.image.{ImageView}
import javafx.scene.image.{Image}
import javafx.scene.layout.{StackPane}
import javafx.scene.{Scene}

import jp.gr.java_conf.polyhedron.splittersprite3.{Atmosphere}
import jp.gr.java_conf.polyhedron.splittersprite3.spirit.{Spirit}
import jp.gr.java_conf.polyhedron.splittersprite3.vanilla

class EffectSpawner(spirit: Spirit) extends vanilla.EffectSpawner(spirit) {
  lazy val upImage = spirit.image("上")
  lazy val downImage = spirit.image("下")
  lazy val leftImage = spirit.image("左")
  lazy val rightImage = spirit.image("右")

  def createInstance(x: Unit) =
    new Effect(upImage, downImage, leftImage, rightImage)
}

class Effect(
      upImage: => Image, downImage: => Image,
      leftImage: => Image, rightImage: => Image)
    extends vanilla.Effect() {
  def apply() {
    val directionImage = Status.direction match {
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
