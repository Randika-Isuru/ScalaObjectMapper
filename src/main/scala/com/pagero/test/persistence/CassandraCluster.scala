package com.pagero.test.persistence

import com.datastax.driver.core.{Cluster, Session}

trait CassandraCluster {

  lazy val cluster: Cluster = {
    val builder = Cluster.builder()
    builder.addContactPoints("localhost")
    builder.withPort(9043)
    builder.build()
  }

  lazy val session: Session = getSession()

  private def getSession(): Session = {
    if (cluster.getMetadata.getKeyspace("documents") != null) {
      cluster.connect("documents")
    } else {
      cluster.connect()
    }
  }

}
