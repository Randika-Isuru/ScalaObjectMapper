package com.pagero.test

import com.datastax.driver.core.utils.UUIDs
import com.datastax.driver.mapping.MappingManager
import com.pagero.test.entity.{Activity, Document, PartyIdBean}
import com.pagero.test.persistence.CassandraCluster

object Main extends App with CassandraCluster{

  lazy val mapper = new MappingManager(session).mapper(classOf[Document])
  val activity = Activity("abcdef", "vijayanga")
  val partyIdBean = Set(PartyIdBean("idtype1", "abcdefg"))

  mapper.save(Document("789", UUIDs.timeBased(), "234", activity, partyIdBean))
}
