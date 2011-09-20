import sbt._
import Keys._

object DocProblem extends Build {

  override lazy val settings = super.settings ++ Seq(crossScalaVersions := Seq("2.8.1", "2.9.1"))
  
  lazy val core = Project("Core", file("core"), aggregate = Seq(supplement))

  lazy val supplement: Project = Project("Supplement", file("supplement")) dependsOn(core)
}
