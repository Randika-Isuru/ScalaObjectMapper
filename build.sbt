
name := "ScalaCaseClassForCqlMappers"

version := "0.1"

scalaVersion := "2.13.0"

libraryDependencies ++= {
  val cassandraVersion = "3.1.1"

  Seq(
    "com.datastax.cassandra"    % "cassandra-driver-core"           % cassandraVersion,
    "com.datastax.cassandra"    % "cassandra-driver-mapping"        % cassandraVersion
  )
}