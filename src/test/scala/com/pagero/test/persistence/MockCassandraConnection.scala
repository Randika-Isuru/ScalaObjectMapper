package com.pagero.test.persistence

import com.datastax.driver.core.{Cluster, Session}
import com.datastax.driver.mapping.{Mapper, MappingManager}
import com.pagero.persistence.DBConnection
import org.cassandraunit.utils.EmbeddedCassandraServerHelper

object MockCassandraConnection extends DBConnection {

  EmbeddedCassandraServerHelper.startEmbeddedCassandra(EmbeddedCassandraServerHelper.CASSANDRA_RNDPORT_YML_FILE)

  val cluster = EmbeddedCassandraServerHelper.getCluster()
  val session = cluster.connect()

  override def getCluster(): Cluster = {
    cluster
  }

  override def getSession(): Session = {
    session
  }

  override def gerMapper[T](obj: Class[T]): Mapper[T] = {
    new MappingManager(session).mapper(obj)
  }
}
