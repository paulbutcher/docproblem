import sbt._
import Keys._

object DocProblem extends Build {

  override lazy val settings = super.settings ++ Seq(crossScalaVersions := Seq("2.8.1", "2.9.1"))
  
  lazy val root = Project("Root", file(".")) aggregate(core, supplement)
    
  lazy val dummy = Project("Dummy", file("dummy"))
  
  lazy val core = Project("Core", file("core")) dependsOn(dummy)

  lazy val supplement = Project("Supplement", file("supplement")) dependsOn(core)
}
