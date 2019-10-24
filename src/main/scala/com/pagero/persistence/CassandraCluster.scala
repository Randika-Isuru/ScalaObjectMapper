/*
package com.pagero.persistence

import com.datastax.driver.core._
import com.pagero.genaral.codec.{IntCodec, OptionCodec, SetCodec}
trait CassandraCluster {

  lazy val cluster: Cluster = {
    val codec: TypeCodec[Set[Int]] = SetCodec(IntCodec)
    val builder = Cluster.builder()
    builder.addContactPoints("localhost")
    builder.withPort(9042)
    builder.getConfiguration.getCodecRegistry.register(codec)
    builder.build()
  }

  lazy val session: Session = getSession()

  private def getSession(): Session = {
    //val intCodec = SetCodec(IntCodec)
    //val intCodec2 = OptionCodec(IntCodec)
    //val intCodecReg: TypeCodec[Int] = IntCodec
    val setIntCodecReg: TypeCodec[Set[Int]] = SetCodec(IntCodec)
    cluster.getConfiguration().getCodecRegistry().register(setIntCodecReg)

    if (cluster.getMetadata.getKeyspace("documents") != null) {
      cluster.connect("documents")
    } else {
      cluster.connect()
    }
  }

}
*/
