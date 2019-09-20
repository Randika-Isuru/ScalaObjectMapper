
name := "ScalaCaseClassForCqlMappers"

version := "0.1"

scalaVersion := "2.12.1"

libraryDependencies ++= {
  val cassandraVersion = "3.3.0"

  Seq(
    "com.datastax.cassandra"    % "cassandra-driver-core"           % cassandraVersion,
    "com.datastax.cassandra"    % "cassandra-driver-mapping"        % cassandraVersion,
    "org.scala-lang"            % "scala-reflect"                   % scalaVersion.value,
    "io.netty"                  % "netty-all"                       % "4.0.44.Final",
    "com.datastax.cassandra"    % "cassandra-driver-extras"         % "3.3.0"               % "optional",
    "ch.qos.logback"            % "logback-classic"                 % "1.2.3"               % "runtime",
    "org.scalatest"             %% "scalatest"                      % "3.0.1"               % "test",
    "org.scalacheck"            % "scalacheck_2.12"                 % "1.13.5"              % "test",
    "org.cassandraunit"         % "cassandra-unit"                  % "3.11.2.0"            % "test"
  )
}

  scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-deprecation", "-unchecked", "-feature", "-Xlint", "-Ywarn-infer-any")

  javacOptions  ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")
