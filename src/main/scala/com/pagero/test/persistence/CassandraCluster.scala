package com.pagero.test.persistence

import com.datastax.driver.core._
import com.pagero.test.genaral.codec.{IntCodec, OptionCodec, SetCodec}
trait CassandraCluster {

  lazy val cluster: Cluster = {
    val builder = Cluster.builder()
    builder.addContactPoints("localhost")
    builder.withPort(9043)
    builder.build()
  }

  lazy val session: Session = getSession()

  private def getSession(): Session = {
    val intCodec: SetCodec[Int] = SetCodec(IntCodec)
    //val intCodec2 = OptionCodec(IntCodec)
    cluster.getConfiguration().getCodecRegistry()
      .register(intCodec);

    if (cluster.getMetadata.getKeyspace("documents") != null) {
      cluster.connect("documents")
    } else {
      cluster.connect()
    }
  }

}
