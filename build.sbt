val gameVersion = "1.0.0"
name := "SampleGame"
version := gameVersion
assemblyJarName := s"../../game/ver${gameVersion}/game.jar"
mainClass := Some("jp.gr.java_conf.polyhedron.splittersprite3.Main")
scalacOptions ++= Seq("-deprecation")
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5"
libraryDependencies += "org.mockito" % "mockito-core" % "2.13.0" % "test"
libraryDependencies += "polyhedron.java_conf.gr.jp" %% "splittersprite" % "3-alpha"
