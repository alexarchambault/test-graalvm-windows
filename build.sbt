scalaVersion := "2.13.0"

name := "test-graalvm-windows"
version := "0.1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.bouncycastle" % "bcprov-jdk15on" % "1.62",
  "org.bouncycastle" % "bcpkix-jdk15on" % "1.62"
)

assemblyMergeStrategy.in(assembly) := {
  case "module-info.class" => MergeStrategy.discard
  // Seems required on Windows
  case x if x.replace('\\', '/').endsWith("/module-info.class") => MergeStrategy.discard
  case x =>
    val oldStrategy = assemblyMergeStrategy.in(assembly).value
    oldStrategy(x)
}
