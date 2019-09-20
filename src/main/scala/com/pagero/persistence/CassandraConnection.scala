package com.pagero.persistence

import com.datastax.driver.core.{Cluster, Session}
import com.datastax.driver.mapping.{Mapper, MappingManager}


object CassandraConnection extends DBConnection {

  private val builder = Cluster.builder()
  builder.addContactPoints("localhost")
  builder.withPort(9043)

  private val cluster: Cluster = builder.build()
  private val session: Session = {
    if (cluster.getMetadata.getKeyspace("documents") != null) {
      cluster.connect("documents")
    } else {
      cluster.connect()
    }
  }
  private val mappingManager =  new MappingManager(session)

  override def getCluster(): Cluster = {
    cluster
  }

  override def getSession(): Session = {
    session
  }

  override def gerMapper[T](obj: Class[T]): Mapper[T] = {
    mappingManager.mapper(obj)
  }

}