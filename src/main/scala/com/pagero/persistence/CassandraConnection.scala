package com.pagero.persistence

import com.datastax.driver.core.{Cluster, CodecRegistry, Session, TypeCodec}
import com.datastax.driver.mapping.{Mapper, MappingManager}
import com.pagero.genaral.codec.{IntCodec, SetCodec}


object CassandraConnection extends DBConnection {

  private val builder = Cluster.builder()
  builder.addContactPoints("localhost")
  builder.withPort(9042)

  //val myJsonCodec: JsonCodec<MyPojo> = new JsonCodec<MyPojo>(MyPojo.class);
  lazy val myCodecRegistry: CodecRegistry = builder.getConfiguration().getCodecRegistry()
  //myCodecRegistry.codecFor(Int)
  //myCodecRegistry.codecFor(scala.collection.Set(Int))
  //myCodecRegistry.register(IntCodec)
  //myCodecRegistry.register(SetCodec(IntCodec))
  builder.withCodecRegistry(myCodecRegistry)


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