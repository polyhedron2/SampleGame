package jp.gr.java_conf.polyhedron.samplegame.crosskey

object Direction {
  sealed abstract class Direction
  case object Up extends Direction
  case object Down extends Direction
  case object Left extends Direction
  case object Right extends Direction
}

object Status {
  var direction: Direction.Direction = Direction.Right
}
